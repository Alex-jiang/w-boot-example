package com.naiteck.example.controller;

import com.naiteck.example.entity.TUserEntity;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/TUserEntity")
@Api(tags = {"用户操作"})
@Slf4j
public class UserController {

    @GetMapping("/TUserEntitys")
    public List<TUserEntity> getTUserEntitys() {
        // 获取用户列表
        return new ArrayList<TUserEntity>();
    }

    @PostMapping("/TUserEntitys")
    public void createTUserEntity(@RequestBody TUserEntity TUserEntity) {
        // 创建新用户
    }

    @GetMapping("/TUserEntitys/{id}")
    public TUserEntity getTUserEntityById(@PathVariable Long id) {
        // 根据ID获取用户信息
        return new TUserEntity();
    }

    @GetMapping("/TUserEntitys/param")
    public void getTUserEntityByIdParam(@RequestParam Long id, @RequestBody TUserEntity TUserEntity) {
        // 更新用户信息
    }

    @DeleteMapping("/TUserEntitys/{id}")
    public void deleteTUserEntity(@RequestHeader Long id) {
        // 根据ID删除用户
    }
}
