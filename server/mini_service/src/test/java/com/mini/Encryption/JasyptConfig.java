package com.mini.Encryption;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "jasypt.encryptor")
public class JasyptConfig {
  private String ivGeneratorClassname;

  private String algorithm;

  private String password;
}
