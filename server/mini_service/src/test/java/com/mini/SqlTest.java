/**
 * @file SqlTest.java
 * @author afcfzf(9301462@qq.com)
 */

package com.mini;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.mini.App;
import com.mini.entity.UserEntity;

@SpringBootTest(classes = App.class)
public class SqlTest {

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    // List<UserEntity> userList = userMapper.selectList(null);
    // System.out.println("????   " + userList.toArray().length);
    // assertEquals(2, userList.size());
    // userList.forEach(System.out::println);
  }
}
