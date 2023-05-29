package com.spring.site.controller;

import com.spring.site.model.Post;
import com.spring.site.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SiteController {
    @Autowired
    SiteService siteService;
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts( ){
        ModelAndView mv = new ModelAndView("posts");
        List <Post> posts = siteService.findAll();
        mv.addObject("posts",posts);
        return mv;

    }

}