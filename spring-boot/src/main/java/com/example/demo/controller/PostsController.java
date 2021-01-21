package com.example.demo.controller;

import com.example.demo.service.PostsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {
    protected static Logger logger=LoggerFactory.getLogger(PostsController.class);

    @Autowired
    private PostsService postsService;


}
