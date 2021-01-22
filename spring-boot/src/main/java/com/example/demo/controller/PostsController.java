package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.entity.Posts;
import com.example.demo.service.PostsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {
    protected static Logger logger=LoggerFactory.getLogger(PostsController.class);

    @Autowired
    private PostsService postsService;

    @RequestMapping("/getPosts")
    @ResponseBody
    public Posts getPosts() {
        Posts posts = postsService.getPosts();
        System.out.println(posts);

        return posts;
    }

}
