package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/30
 */
@Service
@Slf4j
public class UserService {

    public String findUser(String name){
        log.info("正在执行findUser方法");
        return "ok";
    }

}
