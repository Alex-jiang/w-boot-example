package com.naiteck.example.mapper;

import com.naiteck.example.entity.TUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jiangwen
 * @since 2024/08/12
 */
public interface TUserMapper extends BaseMapper<TUserEntity> {

    TUserEntity queryById(@Param("id")Integer id);
}
