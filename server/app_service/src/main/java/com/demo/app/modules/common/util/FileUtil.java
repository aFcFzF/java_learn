/**
 * @file FileUtil.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.common.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtil {
  public static FilePathInfo parseFilePathInfo(String filePath) {
    Path path = Paths.get(filePath);
    String[] fileName = getFileNameAndExt(filePath);

    return new FilePathInfo(
      path.getFileName().toString(),
      fileName[0],
      fileName[1],
      Optional.ofNullable(path.getParent()).map(Path::toString).orElse("")
    );
  }

  private static String[] getFileNameAndExt(String filePath) {
    String[] result = {"", ""};
    String re = "[\\/]?([^\\/]+)\\.([^\\/]+)";
    Pattern pattern = Pattern.compile(re);
    Matcher matcher = pattern.matcher(filePath);
    if (matcher.find()) {
      int matcherNum = matcher.groupCount();
      result[0] = matcherNum >= 1 ? matcher.group(1) : "";
      result[1] = matcherNum >= 2 ? matcher.group(2) : "";
    }
    return result;
  }
}
