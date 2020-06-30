package com.example.demo.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

/**
 * Junit单元测试配置
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/28
 */
@Configurable
@ComponentScan("com.example.demo.circulardependency")
public class JunitCfg {

}
