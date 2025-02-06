/**
 * @file HttpException.java
 * @author afcfzf(9301462@qq.com)
 */

package com.mini.modules.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class HttpException extends Exception {
  public int code;

  public String msg;
}
