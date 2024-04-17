/**
 * @file SqlTest.java
 * @author afcfzf(9301462@qq.com)
 */

package com.wecom.app;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.app.entity.UserEntity;
import com.demo.app.mapper.UserMapper;

// @SpringBootTest
// @RunWith(SpringRunner.class)
public class Sql {
  @Autowired
  private UserMapper userMapper;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<UserEntity> userList = userMapper.selectList(null);
    // assertEquals(5, userList.size());
    userList.forEach(System.out::println);
  }
}
