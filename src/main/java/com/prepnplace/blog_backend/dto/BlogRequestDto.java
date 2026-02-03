package com.prepnplace.blog_backend.dto;

import java.util.List;

public class BlogRequestDto {
    public String title;
    public String content;
    public String coverImageUrl;
    public List<String> tags;
    public boolean published;
}
