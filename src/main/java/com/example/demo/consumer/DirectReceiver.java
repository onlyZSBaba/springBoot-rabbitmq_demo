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
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称
public class DirectReceiver {

    @RabbitHandler
    public void process(Map message){
        System.out.println("第一个 DirectReceiver监听到的消息: "+message.toString());
    }
}
