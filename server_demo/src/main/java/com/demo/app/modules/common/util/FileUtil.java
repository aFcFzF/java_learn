/**
 * @file FileUtil.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.common.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileUtil {
  public static FilePathInfo parseFilePathInfo(String filePath) {
    Path path = Paths.get(filePath);
    return new FilePathInfo(
      path.getName(0).toString(),
      getFileExtName(filePath),
      Optional.ofNullable(path.getParent()).map(Path::toString).orElse("")
    );
  }

  private static String getFileExtName(String filePath) {
    return filePath.substring(filePath.lastIndexOf('.') + 1);
  }
}
