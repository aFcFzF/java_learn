/**
 * @file User.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.entity.UserEntity;
import com.demo.app.mapper.UserMapper;

@RestController
@RequestMapping("/api/user")
public class User {
  @Autowired
  private UserMapper userMapper;

  @PostMapping(value = "/list")
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<UserEntity> userList = userMapper.selectList(null);
    userList.forEach(System.out::println);
  }
}