package com.prepnplace.blog_backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BlogResponseDto {
    public String id;
    public String title;
    public String content;
    public String coverImageUrl;
    public List<String> tags;
    public boolean published;
    public LocalDateTime createdAt;
}
