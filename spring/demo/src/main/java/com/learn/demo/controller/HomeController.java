package com.learn.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/test")
    public String Index() {
        return "你好, 欢迎使用vscode";
    }
}
