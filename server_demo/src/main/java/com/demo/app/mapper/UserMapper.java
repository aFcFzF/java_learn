/**
 * @file UserMapper.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.app.entity.UserEntity;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}
