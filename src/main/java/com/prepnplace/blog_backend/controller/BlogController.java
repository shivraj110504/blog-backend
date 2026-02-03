package com.prepnplace.blog_backend.controller;

import com.prepnplace.blog_backend.dto.BlogRequestDto;
import com.prepnplace.blog_backend.dto.BlogResponseDto;
import com.prepnplace.blog_backend.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public BlogResponseDto create(@RequestBody BlogRequestDto dto) {
        return blogService.createBlog(dto);
    }

    @GetMapping
    public List<BlogResponseDto> getAll() {
        return blogService.getPublishedBlogs();
    }

    @GetMapping("/{id}")
    public BlogResponseDto getOne(@PathVariable String id) {
        return blogService.getBlogById(id);
    }
}
