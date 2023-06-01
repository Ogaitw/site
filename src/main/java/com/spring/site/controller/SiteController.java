package com.spring.site.controller;

import com.spring.site.model.Post;
import com.spring.site.service.SiteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostsDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = siteService.findById(id);
        mv.addObject("post",post);
        return mv;

    }
    @RequestMapping (value = "/newpost",method = RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }
    @RequestMapping (value = "/newpost",method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatorios foram preenchidos");
        if (result.hasErrors()){
        return "redirect:/newpost";
    }
    post.setData(LocalDate.now());
        siteService.save(post);
        return  "redirect:/posts";
    }

}
