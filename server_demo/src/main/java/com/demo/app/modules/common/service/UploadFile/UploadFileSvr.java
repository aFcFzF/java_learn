/**
 * @file 文件上传
 * @author afcfzf(9301462@qq.com)
 */

package com.demo.app.modules.common.service.UploadFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.app.modules.common.util.FilePathInfo;
import com.demo.app.modules.common.util.FileUtil;

@Service
public class UploadFileSvr {
  @Value("${file.upload.dir}")
  private String uploadDir;

  @Value("${server.servlet.contextPath}")
  private String contextPath;

  public List<UploadFileInfo> upload(UploadFileDir dir, MultipartFile[] files) throws IOException {
    ArrayList<UploadFileInfo> result = new ArrayList<>();
    for (MultipartFile file : files) {
      Timestamp ts = new Timestamp(System.currentTimeMillis());
      String dateTimeStr = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(ts);
      FilePathInfo filePathInfo = FileUtil.parseFilePathInfo(file.getOriginalFilename());
      String fileName = filePathInfo.getName() + "_" + dateTimeStr + '.' + filePathInfo.getExt();
      String localDir = "unknown";
      if (dir == UploadFileDir.IMAGE) {
        localDir = "imgs";
      }

      String destDirPath = uploadDir + "/" + localDir;
      File destDir = new File(destDirPath);
      // 判断目录为空创建
      if (!destDir.exists()) {
        if (!destDir.mkdirs()) {
          throw new IOException("目录创建失败: " + destDirPath);
        }
      }

      String filePath = destDirPath + "/" + fileName;
      File dest = new File(filePath);
      file.transferTo(dest);


      UploadFileInfo info = new UploadFileInfo(
          file.getOriginalFilename(),
          contextPath + "/public/" + localDir + "/" + fileName,
          file.getSize());

      result.add(info);
    }

    return result;
  }
}
