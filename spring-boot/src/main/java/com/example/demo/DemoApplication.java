package com.example.demo;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);
		List<Map<String, Object>> result = jdbc.queryForList("select * from posts");
		System.out.println("===== aabbccddeeefff ====== ");
		System.out.println(result);
	}

}
