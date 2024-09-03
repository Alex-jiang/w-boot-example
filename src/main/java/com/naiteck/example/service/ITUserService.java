package com.naiteck.example.service;

import com.naiteck.example.entity.TUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiangwen
 * @since 2024/08/12
 */
public interface ITUserService extends IService<TUserEntity> {
     TUserEntity queryUserById(Integer id);
}
