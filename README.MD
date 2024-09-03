## 项目介绍
- Springboot 2.6.15
- SpringCloud  2021.0.6.1
- SpringCloud Alibaba  2021.0.6.1
- MyBatis Plus 3.5.1
- MySQL 8.0+
- Redisson 3.21
- Swagger2  2.10.0
- Knife4j 2.0.9
- easyExcel
- JWT
- MinIO 3.0.10
- ### banner 生成
```html
http://www.network-science.de/ascii/
```

- ### swagger2
```html
http://localhost:8080/swagger-ui.html
```

- ### Knife4j

与swagger有版本的关联，否则可能会出现版本冲突
本程序使用knife4j 2.0.9 版本，需要对应swagger的2.10.0 版本
配置也有所不同 

swagger> 2.10.0 启动时代码添加注解

```java
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableSwagger2WebMvc
public class SwaggerConfig{
    
}
```
swagger<=2.0.9 启动时代码添加注解
```java
@EnableSwagger2
public class SwaggerConfig{
    
}
```

#### Knife4j 启动密码
```yaml
knife4j:
  enable: true
  basic:
    enable: true
    username: admin
    password: admin
  setting:
    enableFooter: false
```

- doc访问地址
```html
访问地址
http://localhost:8080/doc.html#/home
```


- ### MySQL 数据源
mysql 数据层选用mybatis plus 和 druid
```xml

```
- ### Mybatis plus
```xml

```


Utils
AES\DES
MD5
Date
Redis StringRedisTemplate
RedisTemplate