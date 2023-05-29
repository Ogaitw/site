package com.spring.site.repository;

import com.spring.site.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeSiteRepository  extends JpaRepository <Post,Long> {

}
