
/**
 * @file App.java
 * @author markJia(markjia@tencent.com)
 */

package com.demo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.demo.app.mapper")
public class App {

  @Value("${spring.application.name}")
  private String name;

  @Value("${jasypt.encryptor.password}")
  private String encryptKey;

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @RequestMapping("/")
  String home() {
    return "hello world! \n" + "env: " + name + "-----" + dbUrl;
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
