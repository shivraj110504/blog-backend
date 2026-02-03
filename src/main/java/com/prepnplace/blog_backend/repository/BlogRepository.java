package com.prepnplace.blog_backend.repository;

import com.prepnplace.blog_backend.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BlogRepository extends MongoRepository<Blog, String> {
    List<Blog> findByPublishedTrue();
}
