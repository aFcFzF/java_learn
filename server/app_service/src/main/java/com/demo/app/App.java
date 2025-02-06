/**
 * @file App.java
 * @author 9301462@qq.com
 */

package com.demo.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  @Value("${spring.application.name}")
  private String name;

  @Value("${jasypt.encryptor.password}")
  private String encryptKey;

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @RequestMapping("/")
  String home() {
    return "hello world! \n" + "env: " + name;
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
