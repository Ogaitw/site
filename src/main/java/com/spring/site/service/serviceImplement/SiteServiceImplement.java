package com.spring.site.service.serviceImplement;

import com.spring.site.model.Post;
import com.spring.site.repository.CodeSiteRepository;
import com.spring.site.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SiteServiceImplement implements SiteService {
    @Autowired
    CodeSiteRepository codeSiteRepository;
    @Override
    public List<Post> findAll() {
        return codeSiteRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeSiteRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeSiteRepository.save(post);
    }
}
