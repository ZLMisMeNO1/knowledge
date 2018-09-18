# knowledge
知识汇总

项目组成
1. id-generator
    - [DefaultIdGeneratorImpl](https://github.com/ZLMisMeNO1/knowledge/blob/master/id-generator/src/main/java/cn/i7baoz/knowledge/service/impl/DefaultIdGeneratorImpl.java)基于Twitter-Snowflake算法id生成器简单实现
    - [CacheIdGeneratorImpl](https://github.com/ZLMisMeNO1/knowledge/blob/master/id-generator/src/main/java/cn/i7baoz/knowledge/service/impl/CacheIdGeneratorImpl.java)基于redisid（EVAL，EVALSHA命令）生成器，待补充
2. shiroweb基于shiro框架的简单实现
3. gen_tool基于mybatis-generator的简单扩展
4. 未完待续...

## id-generator

> [snowflake项目地址](https://github.com/twitter/snowflake)

### id组成形式

预留|时间（精确到毫秒）|数据中心id|机器id|序列值
--|--|--|--|--
1位|41位|5位|5位|12位

### 使用方法

在spring-web.xml中配置datacenterId和workerId即可用注入的方式使用。

### 启动方式

打开 test/java/StartServer.java文件，运行main方法，通过访问[获取id](http://localhost:8001/id-generator/id/getId)方式即可。

## gen_tool

1. 基于mybatis-generator的简单扩展
2. 扩展内容为
    - 修改tinyint类型转为Integer
    - 优化注释内容
    - 新增enableBatchInsert批量新增实现
    - 新增enableBatchUpdateChanged批量更新实现
3. 更多实现自定义扩展可查看[扩展与使用说明](https://github.com/ZLMisMeNO1/knowledge/blob/master/gen_tool/%E6%89%A9%E5%B1%95%E4%B8%8E%E4%BD%BF%E7%94%A8%E8%AF%B4%E6%98%8E.md)

## shirocore

### 项目使用技术/框架
1. spring
2. spring-mvc
3. mybatis
4. mysql

该项目待补充，计划编写shiro中内置基础方法。

## shiroweb
基于shirocore的html页面
### 项目使用技术/框架
1. nodejs
2. express
3. 使用Nginx作为反向代理

