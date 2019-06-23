package com.tangyechun.controller;

import com.tangyechun.bean.RespBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 * @since 2019/6/22 16:27
 */

@RestController
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @PostMapping("/upload")
    public RespBean uploadImage(MultipartFile file, HttpServletRequest req) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //    String realPath = req.getSession().getServletContext().getRealPath("/image/");
        String realPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\";
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
            LOGGER.info("创建文件夹：{}", folder);
        }
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf(".")); // 防止重名
        try {
            file.transferTo(new File(folder, newName));
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() +
                    "/images/" + format + "/" + newName;
            LOGGER.info("图片上传成功：{}", folder + "/" + newName);
            LOGGER.info("访问地址：{}", filePath);
            return RespBean.ok("上传成功", filePath);
        } catch (IOException e) {
            LOGGER.error("图片上传失败：{}", e.getMessage());
            return RespBean.error("上传失败");
        }
    }
}
