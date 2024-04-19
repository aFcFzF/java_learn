/**
 * @file RespApiData.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.config.decorator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ApiResp {
}