/**
 * @file User.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("user")
public class UserEntity {
  /**
   * 主键
   */
  @TableId(type = IdType.AUTO)
  private Integer id;

  /**
   * 昵称
   */
  private String nickname;

  /**
   * 头像
   */
  private String avatar;

  /**
   * 个人签名
   */
  @TableField(value = "`desc`")
  private String desc;

  /**
   * 密码
   */
  private String passwd;

  /**
   * 创建时间
   */
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  /**
   * 更新时间
   */
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  /**
   * 是否被删除
   */
  private Integer isDel;
}
