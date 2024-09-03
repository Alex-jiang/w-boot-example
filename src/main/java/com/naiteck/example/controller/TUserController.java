package com.naiteck.example.controller;


import com.naiteck.example.core.Result;
import com.naiteck.example.entity.TUserEntity;
import com.naiteck.example.service.ITUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiangwen
 * @since 2024/08/12
 */
@Slf4j
@Api(tags = {"User Controller"})
@RestController
@RequestMapping("/tuser")
public class TUserController {
    @Autowired
    private ITUserService userService;

    @ApiOperation(value = "selectById_value")
    @GetMapping("selectById")
    public Result<TUserEntity> selectById(@Validated @ApiParam("id") @RequestParam("id") Integer id){
        TUserEntity tUserEntity = userService.queryUserById(id);
        return Result.ok(tUserEntity);
    }
}

