package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/30
 */
@Component
@Aspect
@Slf4j
public class UserAspect {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @AfterReturning(value = "execution(* com.example.demo.service.UserService.findUser(..))",returning = "result")
    public void doAccessCheck(JoinPoint joinPoint,String result){

        //组装要发送的消息内容
        Object[] args = joinPoint.getArgs();
        String name = (String) args[0];

        //service执行成功 则发送消息
        if(result.equals("ok")){
            log.info("消息正在发送到交换机");
            rabbitTemplate.convertAndSend("userExchange","userRoutingKey",name);
        }
    }
}
