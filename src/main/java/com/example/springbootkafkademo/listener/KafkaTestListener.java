package com.example.springbootkafkademo.listener;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author yangzheng
 * @Description: //TODO
 * @Title: KafkaTestListener
 * @date 2020/6/3/003 13:51
 */
@Component
@Slf4j
public class KafkaTestListener {

    @KafkaListener(topics = "testKafka1",groupId = "test")
    public void topic_test(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            JSONObject json = JSONObject.fromObject(record.value());
            log.info("test 消费了： Topic:" + topic + ",Message:" + json);
            ack.acknowledge();
        }
    }
}
