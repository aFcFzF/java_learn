/**
 * @file User.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.User;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.demo.app.config.decorator.ApiResp;
import com.demo.app.entity.UserEntity;
import com.demo.app.mapper.UserMapper;
import com.demo.app.modules.common.service.UploadFile.UploadFileDir;
import com.demo.app.modules.common.service.UploadFile.UploadFileInfo;
import com.demo.app.modules.common.service.UploadFile.UploadFileSvr;

@Controller
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UploadFileSvr uploadFileSvr;

  @PostMapping(value = "/list")
  @ApiResp
  public List<UserEntity> testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<UserEntity> userList = userMapper.selectList(null);
    userList.forEach(System.out::println);
    return userList;
  }

  @PostMapping("/upload_avatar")
  @ApiResp
  public List<UploadFileInfo> uploadUserAvatar(@RequestParam("files") MultipartFile files[]) throws Exception {
    try {
      return uploadFileSvr.upload(UploadFileDir.IMAGE, files);
    } catch (IOException err) {
      throw new Exception("上传失败， traceid: xxxxx");
    }
  }
}
