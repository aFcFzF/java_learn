package com.demo.app.modules.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilePathInfo {
  String name;
  String ext;
  String dir;
}
