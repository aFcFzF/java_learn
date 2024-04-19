/**
 * @file SqlTest.java
 * @author afcfzf(9301462@qq.com)
 */

package com.wecom.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.demo.app.App;
import com.demo.app.entity.UserEntity;
import com.demo.app.mapper.UserMapper;

@SpringBootTest(classes = App.class)
public class SqlTest {
  @Autowired
  private UserMapper userMapper;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<UserEntity> userList = userMapper.selectList(null);
    System.out.println("????   " + userList.toArray().length);
    assertEquals(2, userList.size());
    userList.forEach(System.out::println);
  }
}
