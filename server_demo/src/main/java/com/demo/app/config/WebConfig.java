/**
 * @file WebConfig.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import com.demo.app.config.interceptor.ResponseFormattingInterceptor;

// @Configuration
// public class WebConfig implements WebMvcConfigurer {

//   @Autowired
//   private ResponseFormattingInterceptor responseFormattingInterceptor;

//   @Override
//   public void addInterceptors(InterceptorRegistry registry) {
//     System.out.println("??????? 走到这里");
//     registry
//         .addInterceptor(responseFormattingInterceptor)
//         .addPathPatterns("/**")
//         .order(Ordered.HIGHEST_PRECEDENCE);
//   }
// }
