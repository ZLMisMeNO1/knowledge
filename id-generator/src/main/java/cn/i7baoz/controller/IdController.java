package cn.i7baoz.controller;

import cn.i7baoz.config.GeneratorConfig;
import cn.i7baoz.generator.impl.DefaultIdGenerator;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DefaultIdGenerator defaultIdGenerator;

    @RequestMapping("/getId.do")
    public Map<String,String> getId() {
        Map<String,String> map = Maps.newHashMap();
        long id  = defaultIdGenerator.generateId();
        GeneratorConfig config = defaultIdGenerator.parseId(id);
        map.put("id",Long.toString(id));
        map.put("config", JSONObject.toJSONString(config));
        return map;
    }
}
