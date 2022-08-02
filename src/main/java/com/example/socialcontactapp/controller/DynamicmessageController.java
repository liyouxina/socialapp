package com.example.socialcontactapp.controller;

import cn.hutool.core.util.SerializeUtil;
import cn.hutool.core.util.StrUtil;
import com.example.socialcontactapp.entity.Dynamicmessage;
import com.example.socialcontactapp.service.DynamicmessageService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.socialcontactapp.utils.StringConstant.FILENAME;

/**
 * (Dynamicmessage)表控制层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@RestController
@RequestMapping("dynamicmessage")
public class DynamicmessageController {
    /**
     * 服务对象
     */
    @Resource
    private DynamicmessageService dynamicmessageService;

    @PostMapping()
    public R publishDynamics(String token, String label, String address, Integer nums, String topic, @ModelAttribute List<MultipartFile> pictures, String content) {
        if (pictures.size() > 9)
            return R.error().data("msg", "超过最大上传数量");
        List<String> list = new ArrayList<>();
//        上传本地
        for (MultipartFile picture : pictures) {
            File targetFile = new File(FILENAME, picture.getOriginalFilename());
            try {
                picture.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            list.add(picture.getOriginalFilename());
        }
        String s = SerializeUtil.serialize(list).toString();
        if (StrUtil.isNotBlank(token))
            return this.dynamicmessageService.publishDynamics(token, label, address, nums, topic, s, content);
        return R.error().data("msg", "该用户没有登陆");
    }

    @GetMapping()
    public R queryByUserId(String token, int offset) {
        return this.dynamicmessageService.queryByUserId(token, offset);
    }

    @DeleteMapping()
    public R deleteById(Integer messageid, String token) {
        return this.dynamicmessageService.deleteById(token, messageid);
    }

    @PutMapping()
    public R update(Dynamicmessage dynamicmessage, String token) {
        return this.dynamicmessageService.update(dynamicmessage, token);
    }

}