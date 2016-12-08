package com.lance.logging.service;

import com.lance.logging.websocket.MyWebSocket;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service@Slf4j
public class Listener {
    @Autowired
    private MyWebSocket myWebSocket;

    /**
     * 监听kafka消息,如果有消息则消费,同步数据
     * @param record 消息实体bean
     */
    @KafkaListener(topics = "lance-topic")
    public void listen(ConsumerRecord<String, String> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            //log.info("========="+message.toString());
            try {
                myWebSocket.sendMessage(record.toString());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("发送错误");
            }
        }
    }

}