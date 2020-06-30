package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 发送消息控制器
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/29
 */
@RestController
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/sendMessage")
    public String sendMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message: hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "send message success!";
    }

    @PostMapping("/sendTopicMsg1")
    public String sendTopicMsg1(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "topic message: M A N!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", map);

        return "send topic message success!";
    }

    @PostMapping("/sendTopicMsg2")
    public String sendTopicMsg2(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "topic message: W O M A N!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", map);

        return "send topic message success!";
    }

    @PostMapping("/sendFanoutMsg")
    public String sendFanoutMsg(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: fanout test message";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);

        return "send fanout message success!";
    }

    @PostMapping("/testMessageACK")
    public String testMessageACK(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: test message ACK ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到 不存在的 交换机null-Exchange
        rabbitTemplate.convertAndSend("null-Exchange", "TestDirectRouting", map);

        return "send  message success!";
    }

    @PostMapping("/testMessageACK2")
    public String testMessageACK2(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: test message ACK 2 ";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机lonelyDirectExchange
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", map);

        return "send  message success!";
    }
}
