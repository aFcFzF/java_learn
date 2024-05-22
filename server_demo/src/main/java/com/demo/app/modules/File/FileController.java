/**
 * @file TestController.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.File;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayway.jsonpath.InvalidPathException;

@Controller
@RequestMapping("/api/download")
public class FileController {

  @Value("${file.upload.dir}")
  private String fileUploadDir;

  @CrossOrigin(origins = "http://127.0.0.1:8787")
  @PostMapping("/bigFile")
  public ResponseEntity<Resource> bigFileTest(@RequestHeader("Range") String range) throws IOException, Exception {
    if (range.equals(null)) {
      throw new Exception("参数错误, 分片下载必须指定headers.Range");
    }

    // throw new Exception("未知错误");

    // String filePath = fileUploadDir + File.separator +
    // "bigFiles/bigfile_postman_for_macOS_arm64.zip";
    String filePath = fileUploadDir + File.separator + "bigFiles" + File.separator + "服务商账单列表-2024年Q1-BEST.xlsx";
    // String filePath = fileUploadDir + File.separator + "bigFiles" + File.separator + "test.txt";
    final File file = new File(filePath);

    if (!file.exists()) {
      throw new IOException(file.getAbsolutePath());
    }

    final FileSystemResource resp = new FileSystemResource(file);

    System.out.println("文件名： " + file.getName());

    final HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.LAST_MODIFIED, String.valueOf(file.lastModified()));
    headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
    headers.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));
    headers.set("x-file-hash", "0011");
    headers.set(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,
        HttpHeaders.CONTENT_DISPOSITION + ", " + HttpHeaders.CONTENT_RANGE + ", " + "x-file-hash");

    return ResponseEntity
        .ok()
        .headers(headers)
        .contentLength(file.length())
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .body(resp);
  }

  @CrossOrigin(origins = "http://127.0.0.1:8787")
  @PostMapping("/bigFileInfo")
  public Map<String, String> bigFileInfo() {
    String filePath = fileUploadDir + File.separator + "bigFiles/bigfile_postman_for_macOS_arm64.zip";
    final File file = new File(filePath);

    // 文件信息
    String fileSize = file.length() / 1000 / 1000 + "MB";
    System.out.println(file.length());
    Map<String, String> map = new HashMap<>();
    map.put("size", fileSize);
    map.put("fileExist", file.exists() + "");
    map.put("fileAbsPath", file.getAbsolutePath());
    map.put("filePath", filePath);
    return map;
  }
}
