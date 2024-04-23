package com.demo.app.config.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import lombok.Data;

@Data
class Obj {
  private String name = "11";
}

@ControllerAdvice
public class ResponseFormattingAdvice implements ResponseBodyAdvice<Object> {
  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    // 指定需要拦截的返回类型，可以根据需要进行修改
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request, ServerHttpResponse response) {
    // 在这里对响应内容进行格式化操作
    // 您可以修改body对象或者使用自定义的响应对象来包装返回值
    // response.("ookk", "000");
    System.out.println(body);
    return new Obj();
  }
}