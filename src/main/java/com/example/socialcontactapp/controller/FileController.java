package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.utils.R;
import com.example.socialcontactapp.utils.UploadImage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileController {
    @RequestMapping("/image")
    public R uploadImage(@RequestParam(value = "file") MultipartFile multipartFile) {
        // 调用写好的工具类
        String imagePath = UploadImage.upload(multipartFile);

        if (imagePath == null) {
            return R.error().message("上传失败");
        } else {
            return R.ok().data("imgUrl", imagePath);
        }
    }
}
