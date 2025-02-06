/**
 * @file StaticResourceConfiguration.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.config.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurationSupport {
  @Value("${file.upload.dir}")
  private String fileUploadDir;

  @Override
  public void addResourceHandlers(@NonNull ResourceHandlerRegistry register) {
    if (fileUploadDir == null) {
      System.err.println("file.upload.dir 不存在");
      return;
    }

    System.out.println("log: 挂载public" + "file://" + fileUploadDir);
    register
      .addResourceHandler("/public/**")
      .addResourceLocations("file://" + fileUploadDir + "/");
  }
}
