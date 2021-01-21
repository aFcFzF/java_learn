package com.example.demo.dao;

import java.util.*;

import com.example.demo.entity.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsDao extends JpaRepository<Posts, Long> {
    List<Posts> getPosts();
}
