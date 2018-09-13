package cn.i7baoz.knowledge.controller;

import cn.i7baoz.knowledge.config.GeneratorConfig;
import cn.i7baoz.knowledge.service.IdGeneratorService;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@RestController
@RequestMapping("/id")
public class IdController {

    @Autowired
    private IdGeneratorService idGeneratorService;


    @RequestMapping("/getId")
    public Map<String,String> getId() {

        Map<String,String> map = Maps.newHashMap();
        long id  = idGeneratorService.generateId();
        GeneratorConfig config = idGeneratorService.parseId(id);
        map.put("id",Long.toString(id));
        map.put("config", JSONObject.toJSONString(config));
        return map;
    }
}
