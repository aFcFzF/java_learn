/**
 * @file HttpException.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpException extends Exception {
  public int code;

  public String msg;
}
