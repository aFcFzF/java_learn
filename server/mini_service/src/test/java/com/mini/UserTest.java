/**
 * @file SqlTest.java
 * @author afcfzf(9301462@qq.com)
 */

package com.mini;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.mini.modules.common.util.FilePathInfo;
import com.mini.modules.common.util.FileUtil;

@SpringBootTest(classes = App.class)
public class UserTest {
  @Test
  public void testFileInfo() {
    FilePathInfo info = FileUtil.parseFilePathInfo("img.png");
    System.out.println(info);
    assertEquals("png", info.getExt());
    assertEquals("img", info.getName());
    assertEquals("", info.getDir());
  }
}
