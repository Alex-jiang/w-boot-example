package com.naiteck.example.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;
import java.util.Scanner;

public class GeneratorUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入作者: ");
        String author = scanner.nextLine();//作者
        System.out.print("请输入数据库表名: ");
        String tableName = scanner.nextLine();//数据库表名
        String url = "jdbc:mysql://127.0.0.1:3306/wboot?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        String username = "wboot";//数据库名用户
        String password = "wboot";//数据库密码
        String path = System.getProperty("user.dir");//获取当前项目的根目录
        FastAutoGenerator.create(url,username, password)
                //全局配置
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(path+"/src/main/java/")// 指定输出目录
                            .disableOpenDir()//禁止打开输出目录
                            .commentDate("yyyy/MM/dd");//设置日期格式

                })
                //包配置
                .packageConfig(builder -> {
                    builder.parent("com.naiteck.example") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, path+"/src/main/resources/dao")); // 设置mapperXml生成路径
                })
                //策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(tableName); // 设置需要生成的表名
                    builder.entityBuilder()
                            .enableLombok()//开启lombok,不开启会帮你生成set，get方法
                            .formatFileName("%sEntity")//生成的实体类的格式,%s:这个是表名
                            .idType(IdType.AUTO);//设置ID主键自增
                })
                .execute();
    }

}
