package com.naiteck.example.controller;

import com.naiteck.example.config.MailProperties;
import com.naiteck.example.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("example")
@Api(tags = {"Example Controller"})
public class ExampleController {
    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private RedisUtils redisUtils;
    @GetMapping("test")
    @ApiOperation("测试的方法")
    public String test(){
        System.out.println(mailProperties.getMail());
        log.info("example-测试的方法"+mailProperties.getMail());
        redisUtils.set("123",mailProperties.getMail());
        return "hahah";
    }

    @GetMapping("getMail")
    @ApiOperation("获取邮件")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="mail" ,value = "目标邮件",defaultValue = "mail",dataType = "String"),
            @ApiImplicitParam(name ="from" , value = "源邮件",defaultValue = "from",dataType = "String")
    })
    public String getMail(String mail,
                          String from){
        String result = "";
        if(mail !="" && mail !=null){
            result += mailProperties.getMail();
        }
        if(from !="" && from !=null){
            result += ";"+mailProperties.getFrom();
        }
        return result;
    }


}

