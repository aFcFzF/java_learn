package com.wecom.app;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import com.wecom.app.Encryption.JasyptConfig;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

@SpringBootApplication
@RunWith(SpringRunner.class)
@SpringBootTest()
public class Encryption1 {
  @Value("${spring.application.name}")
  private String applicationName;

  @Autowired
  private JasyptConfig jasyptConfig;

  private String getClassPath() throws IOException {
    ClassPathResource resource = new ClassPathResource("application.properties");
    return resource.getURI().toString();
  }

  private StringEncryptor stringEncryptor() {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword(jasyptConfig.getPassword());
    encryptor.setAlgorithm(jasyptConfig.getAlgorithm());
    return encryptor;
  }

  @Test
  public void testDecryption() throws IOException {
    System.out.println("Application Name: " + applicationName);
    StringEncryptor encryptor = stringEncryptor();
    String deString = encryptor.decrypt("QJNEs8WfhnOSSMMXqQgkVg==");
    System.out.println("deString: " + deString);
    System.out.println("jasypt Pwd: " + jasyptConfig);
    assertEquals(deString, "pass");
    String classPath = getClassPath();
    System.out.println("classPath: " + classPath);
  }
}