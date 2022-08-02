package com.example.socialcontactapp.service.impl;

import com.example.socialcontactapp.dao.DynamicCommentDao;
import com.example.socialcontactapp.dao.DynamicmessageDao;
import com.example.socialcontactapp.entity.DynamicComment;
import com.example.socialcontactapp.service.DynamicCommentService;
import com.example.socialcontactapp.utils.JWTUtil;
import com.example.socialcontactapp.utils.R;
import com.example.socialcontactapp.utils.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DynamicComment)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 18:05:37
 */
@Service("dynamicCommentService")
public class DynamicCommentServiceImpl implements DynamicCommentService {
    @Resource
    private DynamicCommentDao dynamicCommentDao;

    @Resource
    private DynamicmessageDao dynamicmessageDao;

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public R queryAllByLimit(Integer messageId, int offset, int limit) {
        if (messageId == null) {
            return R.error().data("msg", "参数缺失");
        }
        List<DynamicComment> dynamicComments = this.dynamicCommentDao.queryAllByLimit(messageId, offset, limit);
        return R.ok().data("data", dynamicComments);
    }

    /**
     * 新增数据
     *
     * @param dynamicComment 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(String token, DynamicComment dynamicComment) {
        dynamicComment.setDatatime(Util.now());
        Long userId = JWTUtil.getUserId(token);
        if (userId == null) {
            return R.error().data("msg", "用户验证已经过期");
        }
        if (dynamicComment.getMessageid() == null) {
            return R.error().data("msg", "参数缺失");
        }
        dynamicComment.setUserid(userId);
        System.out.println(dynamicComment);
        if (this.dynamicCommentDao.insert(dynamicComment) <= 0)
            return R.error().data("msg", "评论失败");
        dynamicmessageDao.addComment(dynamicComment.getMessageid());
        return R.ok();
    }


    /**
     * 通过主键删除数据
     *
     * @param messageid 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(String token, Integer messageid) {
        Long userId = JWTUtil.getUserId(token);
        if (userId == null)
            return R.error().data("msg", "用户验证已经过期");
        if (messageid == null) {
            return R.error().data("msg", "参数缺失");
        }
        if (this.dynamicCommentDao.deleteById(messageid, userId) > 0) {
            dynamicmessageDao.reduceComment(messageid);
            return R.ok();
        } else
            return R.error();
    }
}