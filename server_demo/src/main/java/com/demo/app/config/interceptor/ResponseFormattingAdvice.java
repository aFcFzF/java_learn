/**
 * @file 格式化通用返回
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.config.interceptor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import com.demo.app.config.decorator.ApiResp;
import com.demo.app.modules.common.util.HttpException;

import io.micrometer.common.lang.NonNull;
import lombok.Data;

@Data
class ApiResult {
  private int code = 0;

  private String message = "";

  private Object data = null;

  public ApiResult(int code, String msg) {
    this.code = code;
    this.message = msg;
  }

  public ApiResult(Object data) {
    this.data = data;
  }
}

@RestControllerAdvice
public class ResponseFormattingAdvice implements ResponseBodyAdvice<Object> {
  @Override
  public boolean supports(@NonNull MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return returnType.hasMethodAnnotation(ApiResp.class);
  }

  @Override
  public Object beforeBodyWrite(
      @NonNull Object body,
      MethodParameter returnType,
      MediaType selectedContentType,
      Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request,
      ServerHttpResponse response) {
    return new ApiResult(body);
  }

  @ExceptionHandler(Exception.class)
  public final ApiResult exceptionHandler(Exception ex, WebRequest request) {
    if (ex instanceof HttpException) {
      HttpException httpEx = (HttpException) ex;
      return new ApiResult(httpEx.getCode(), httpEx.getMsg());
    }
    int code = 500;
    String errMsg = ex.getMessage();
    return new ApiResult(code, errMsg);
  }
}