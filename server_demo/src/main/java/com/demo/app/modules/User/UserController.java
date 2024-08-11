/**
 * @file User.java
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.User;

import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.app.config.decorator.ApiResp;
import com.demo.app.entity.UserEntity;
import com.demo.app.modules.User.models.LoginInfo;
import com.demo.app.modules.common.service.UploadFile.UploadFileDir;
import com.demo.app.modules.common.service.UploadFile.UploadFileInfo;
import com.demo.app.modules.common.service.UploadFile.UploadFileSvr;
import com.demo.app.modules.common.util.HttpException;

import io.ebean.Database;
import io.ebean.Query;
import lombok.Data;
import net.minidev.json.JSONObject;

@Data
class Test {
  private Object name = "abc";
}

@Controller
@RequestMapping("/api/user")
public class UserController {
  private String authUrl = "https://api.weixin.qq.com/sns/jscode2session";

  @Autowired
  private Database db;

  @Autowired
  private UploadFileSvr uploadFileSvr;

  @PostMapping(value = "/list")
  @ApiResp
  public List<UserEntity> testSelect() {
    Query<UserEntity> userQuery = db.find(UserEntity.class);
    System.out.println(("----- selectAll method test ------"));
    List<UserEntity> userList = userQuery.findList();
    userList.forEach(System.out::println);
    return userList;
  }

  @PostMapping(value = "/loginStatus")
  @ApiResp
  public LoginInfo loginStatus(
      @RequestHeader(value = "auth-token", required = false) String authToken) throws HttpException {
    System.out.println("== authToken: " + authToken);
    if (authToken == null) {
      throw new HttpException(401, "登录失败");
    }

    Query<UserEntity> userQuery = db.find(UserEntity.class);

    UserEntity userInfo = userQuery
        .where()
        .eq("autoToken", authToken)
        .findOne();

    if (userInfo == null) {
      throw new HttpException(401, "登录失败");
    }

    return new LoginInfo(userInfo.getNickname(), userInfo.getAvatar());
  }

  @PostMapping("/login")
  @ApiResp
  public String login(@RequestBody(required = false) String wxCode) {
    System.out.println("===== wxCode: " + wxCode);
    OkHttpClient okHttpClient = new OkHttpClient();
    JSONObject json = new JSONObject();
    json.put("a", "b");

    Test ins = new Test();
    System.out.println(ins.getName());

    return "1122";
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
