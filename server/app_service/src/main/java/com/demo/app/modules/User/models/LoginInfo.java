/**
 * @file LoginInfo.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.User.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginInfo {
  /**
   * 昵称
   */
  String nickname;

  /**
   * 头像
   */
  String avatar;
}
