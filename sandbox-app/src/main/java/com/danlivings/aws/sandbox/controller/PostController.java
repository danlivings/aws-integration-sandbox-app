package com.danlivings.aws.sandbox.controller;

import com.danlivings.aws.sandbox.entity.Post;
import com.danlivings.aws.sandbox.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getPosts(Model model) {
        model.addAttribute("posts", service.getPosts())
                .addAttribute("post", new Post());
        return "posts";
    }

    @PostMapping("/")
    public String postPosts(@ModelAttribute Post post, Model model) {
        service.addPost(post);

        return getPosts(model);
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
