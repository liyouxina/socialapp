package com.example.socialcontactapp.service;

import com.example.socialcontactapp.entity.RechargeRecorder;
import com.example.socialcontactapp.utils.R;

/**
 * (RechargeRecorder)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 15:22:58
 */
public interface RechargeRocorderService {
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    R queryAllByLimit(String token, int offset, int limit);
    /**
     * 新增数据
     *
     * @param rechargeRecorder 实例对象
     * @return 实例对象
     */

    R insert(String token, RechargeRecorder rechargeRecorder);

}