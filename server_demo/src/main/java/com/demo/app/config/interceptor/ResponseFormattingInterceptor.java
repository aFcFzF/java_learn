/**
 * @file ResponseFormattingInterceptor.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @Configuration
// public class ResponseFormattingInterceptor implements HandlerInterceptor {

//   @Override
//   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//       ModelAndView modelAndView) throws Exception {
//     // Modify the response body here
//     // Format the body or perform any other modifications
//     // System.out.println("=====: " + response);
//     response.addHeader("test", "hehe");
//     System.out.println("======= 走了response");
//     response.setContentType("application/json");
//     response.getWriter().write("{}");
//   }
// }