package com.wecom.app;

import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication
public class EncryptionTest {
  @Value("${spring.application.name}")
  private String applicationName;


  private String getClassPath() throws IOException {
    ClassPathResource resource = new ClassPathResource("application.properties");
    return resource.getURI().toString();
  }

  @Test
  public void testApplicationName() throws IOException {
    System.out.println("Application Name: " + applicationName);
    String classPath = getClassPath();
    System.out.println("classPath: " + classPath);
  }
}