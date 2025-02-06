/**
 * @file EbeanConfiguration.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.config.configuration;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EbeanConfiguration {

  @Bean
  public Database database() {
    DatabaseConfig config = new DatabaseConfig();
    config.setName("java_learn"); // db is the default name
    // config.setCurrentUserProvider(currentUser);
    config.loadFromProperties();
    return DatabaseFactory.create(config);
  }
}
