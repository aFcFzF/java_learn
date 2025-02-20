/**
 * @file EbeanConfiguration.java
 * @author afcfzf(9301462@qq.com)
 */

package com.mini.config.configuration;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.datasource.DataSourceConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EbeanConfiguration {

  @Value("${datasource.db.url}")
  private String dbUrl;

  @Value("${datasource.db.username}")
  private String dbUserName;

  @Value("${datasource.db.password}")
  private String dbPwd;

  @Bean
  public Database database() {
    DataSourceConfig dbConfig = new DataSourceConfig();
    dbConfig.setUsername(dbUserName);
    dbConfig.setPassword(dbPwd);
    dbConfig.setUrl(dbUrl);

    DatabaseConfig config = new DatabaseConfig();
    config.setDataSourceConfig(dbConfig);

    return DatabaseFactory.create(config);
  }
}
