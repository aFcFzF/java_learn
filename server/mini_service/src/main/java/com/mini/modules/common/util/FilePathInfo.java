/**
 * @file FilePathInfo.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilePathInfo {
  /**
   * 文件全名
   */
  String fullName;
  /**
   * 文件名
   */
  String name;
  /**
   * 文件后缀
   */
  String ext;
  /**
   * 文件目录
   */
  String dir;
}
