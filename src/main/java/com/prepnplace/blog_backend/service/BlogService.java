package com.prepnplace.blog_backend.service;

import com.prepnplace.blog_backend.dto.BlogRequestDto;
import com.prepnplace.blog_backend.dto.BlogResponseDto;

import java.util.List;

public interface BlogService {

    BlogResponseDto createBlog(BlogRequestDto dto);

    List<BlogResponseDto> getPublishedBlogs();

    BlogResponseDto getBlogById(String id);
}
