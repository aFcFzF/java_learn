/**
 * @file SqlTest.java
 * @author afcfzf(9301462@qq.com)
 */

package com.wecom.app;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.demo.app.App;
import com.demo.app.modules.common.util.FilePathInfo;
import com.demo.app.modules.common.util.FileUtil;

@SpringBootTest(classes = App.class)
public class UserTest {
  @Test
  public void testFileInfo() {
    FilePathInfo info = FileUtil.parseFilePathInfo("img.png");
    System.out.println(info);
    // assertEquals("png", info.getExt());
    // assertEquals("img", info.getName());
    // assertEquals("", info.getDir());
  }
}
