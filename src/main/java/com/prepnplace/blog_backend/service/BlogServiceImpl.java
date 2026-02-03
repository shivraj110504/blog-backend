package com.prepnplace.blog_backend.service;

import com.prepnplace.blog_backend.dto.BlogRequestDto;
import com.prepnplace.blog_backend.dto.BlogResponseDto;
import com.prepnplace.blog_backend.exception.ResourceNotFoundException;
import com.prepnplace.blog_backend.model.Blog;
import com.prepnplace.blog_backend.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogResponseDto createBlog(BlogRequestDto dto) {

        Blog blog = new Blog();
        blog.setTitle(dto.title);
        blog.setContent(dto.content);
        blog.setCoverImageUrl(dto.coverImageUrl);
        blog.setTags(dto.tags);
        blog.setPublished(dto.published);
        blog.setCreatedAt(LocalDateTime.now());
        blog.setUpdatedAt(LocalDateTime.now());

        blogRepository.save(blog);
        return map(blog);
    }

    @Override
    public List<BlogResponseDto> getPublishedBlogs() {
        return blogRepository.findByPublishedTrue()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public BlogResponseDto getBlogById(String id) {
        Blog blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        return map(blog);
    }

    private BlogResponseDto map(Blog blog) {
        BlogResponseDto dto = new BlogResponseDto();
        dto.id = blog.getId();
        dto.title = blog.getTitle();
        dto.content = blog.getContent();
        dto.coverImageUrl = blog.getCoverImageUrl();
        dto.tags = blog.getTags();
        dto.published = blog.isPublished();
        dto.createdAt = blog.getCreatedAt();
        return dto;
    }
}
