package com.example.demo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/30
 */
@Component
@Slf4j
public class UserReceiver {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "userQueue",durable = "true"),
                    exchange = @Exchange(value = "userExchange",type = "topic",durable = "true"),
                    key = "userRoutingKey")
            )
    public void receiveMessage(String name){
        log.info("消息已经收到了 : {}",name);
        System.out.println("找到了"+name);
    }

}
