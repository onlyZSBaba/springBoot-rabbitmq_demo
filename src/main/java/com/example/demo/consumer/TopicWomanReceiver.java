package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/29
 */
@Component
@RabbitListener(queues = "topic.woman")
public class TopicWomanReceiver {

    @RabbitHandler
    public void process(Map message){
        System.out.println("TopicWomanReceiver 收到消息 : "+message.toString());
    }
}
