package com.naiteck.example.service.impl;

import com.naiteck.example.entity.TUserEntity;
import com.naiteck.example.mapper.TUserMapper;
import com.naiteck.example.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiangwen
 * @since 2024/08/12
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUserEntity> implements ITUserService {

    @Autowired
    private TUserMapper userMapper;

    public TUserEntity queryUserById(Integer id){
        TUserEntity user =userMapper.queryById(id);
        return user;
    }
}
