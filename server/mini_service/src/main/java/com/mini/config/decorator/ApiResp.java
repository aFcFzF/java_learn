/**
 * @file RespApiData.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.config.decorator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.ResponseBody;


@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@ResponseBody
public @interface ApiResp {
}