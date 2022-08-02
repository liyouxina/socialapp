package com.example.socialcontactapp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.example.socialcontactapp.entity.Complaint;
import com.example.socialcontactapp.dao.ComplaintDao;
import com.example.socialcontactapp.service.ComplaintService;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Complaint)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 08:11:57
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private ComplaintDao complaintDao;



    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(String token, Complaint complaint) {
        if(StrUtil.isBlank(token))
            return R.error().data("msg","验证过期");
        Long userId = JWTUtil.getUserId(token);
        if (userId == null) {
            return R.error().data("msg","验证失败");
        }
        complaint.setUserid(userId);
        this.complaintDao.insert(complaint);
        return R.ok().data("msg","申请投诉成功");
    }


}