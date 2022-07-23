package com.example.socialcontactapp.controller;

import com.example.socialcontactapp.entity.Complaint;
import com.example.socialcontactapp.service.ComplaintService;
import com.example.socialcontactapp.utils.R;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.socialcontactapp.utils.StringConstant.COMPLAINT;

/**
 * (Complaint)表控制层
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@RestController
@RequestMapping("complaint")
public class ComplaintController {
    /**
     * 服务对象
     */
    @Resource
    private ComplaintService complaintService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @PostMapping()
    public R insert(String token, @ModelAttribute List<MultipartFile> pictures, Complaint complaint) {
        if (pictures.size() > 3)
            return R.error().data("msg", "超过最大上传数量");
        List<String> list = new ArrayList<>();
//        上传本地
        for (MultipartFile picture : pictures) {
            File targetFile = new File(COMPLAINT, picture.getOriginalFilename());
            try {
                picture.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (pictures.get(0) != null)
                complaint.setPicture1(pictures.get(0).getOriginalFilename());
            if (pictures.get(1) != null)
                complaint.setPicture2(pictures.get(1).getOriginalFilename());
            if (pictures.get(2) != null)
                complaint.setPicture3(pictures.get(2).getOriginalFilename());
        } catch (IndexOutOfBoundsException e) {

        }
        return this.complaintService.insert(token, complaint);
    }
}