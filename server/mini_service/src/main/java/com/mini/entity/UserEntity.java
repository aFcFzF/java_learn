/**
 * @file User.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Table(name = "user")
@Entity
public class UserEntity {
  /**
   * 主键
   */
  @Id()
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
  @Column(name = "`desc`")
  private String desc;

  /**
   * 密码
   */
  private String passwd;

  /**
   * 创建时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  /**
   * 更新时间
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updateTime;

  /**
   * 是否被删除
   */
  private Integer isDel;
}
