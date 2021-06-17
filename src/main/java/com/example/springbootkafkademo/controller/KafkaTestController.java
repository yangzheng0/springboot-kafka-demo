package com.example.springbootkafkademo.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangzheng
 * @version 1.0
 * @description
 * @date 2021/6/18 018 1:19
 */
@RestController
@Slf4j
public class KafkaTestController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("/test")
    public String test(){
        log.info("向 testKafka 发送消息");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","test");
        kafkaTemplate.send("testKafka1", jsonObject.toString());
        return "success";
    }
}
