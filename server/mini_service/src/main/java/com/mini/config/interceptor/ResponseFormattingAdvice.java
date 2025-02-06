/**
 * @file 格式化通用返回
 * @author afcfzf(9301462@qq.com)
 */

package com.mini.config.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import com.mini.config.decorator.ApiResp;
import com.mini.modules.common.util.HttpException;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
class ApiResultBase {
  private int code = 0;

  private String message = "";

  private Object data = null;

  public ApiResultBase(int code, String msg) {
    this.code = code;
    this.message = msg;
  }
}

@Data
@EqualsAndHashCode(callSuper=false)
class ApiResultObj extends ApiResultBase {
  private Object data = null;

  public ApiResultObj(Object data) {
    super(0, "");
    this.data = data;
  }
}

@Data
@EqualsAndHashCode(callSuper=false)
class ApiResultStr extends ApiResultBase {
  private String data = "";

  public ApiResultStr(String data) {
    super(0, "");
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
    if (body instanceof String) {
      return new ApiResultStr((String) body);
    }
    return new ApiResultObj(body);
  }

  @ExceptionHandler(Exception.class)
  public final ApiResultBase exceptionHandler(Exception ex, WebRequest request) {
    if (ex instanceof HttpException) {
      HttpException httpEx = (HttpException) ex;
      return new ApiResultBase(httpEx.getCode(), httpEx.getMsg());
    }

    int code = 500;
    String errMsg = ex.getMessage();
    return new ApiResultBase(code, errMsg);
  }
}
// auto-refresh 自动刷新