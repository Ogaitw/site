package com.spring.site.service;

import com.spring.site.model.Post;

import java.util.List;

public interface SiteService {
    List<Post>findAll();
    Post findById(Long id);
    Post save (Post post);
}
