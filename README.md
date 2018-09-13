# knowledge
知识汇总

项目组成
1. id-generator
    - [DefaultIdGeneratorImpl](cn.i7baoz.knowledge.service.impl.DefaultIdGeneratorImpl)基于Twitter-Snowflake算法id生成器简单实现
    - [CacheIdGeneratorImpl](cn.i7baoz.knowledge.service.impl.CacheIdGeneratorImpl)基于redisid（EVAL，EVALSHA命令）生成器，待补充
2. shiroweb基于shiro框架的简单实现
3. 未完待续...

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

## shiroweb

### 项目使用技术/框架
1. spring
2. spring-mvc
3. mybatis
4. mysql

该项目待补充，计划编写shiro中内置基础方法。
