/**
 * @file UploadFileInfo.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.common.service.UploadFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileInfo {
  String originName;
  String url;
  Long fileSize;
}
