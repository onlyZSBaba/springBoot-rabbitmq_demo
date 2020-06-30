package com.example.demo.test;

import com.example.demo.circulardependency.DependencyA;
import com.example.demo.circulardependency.DependencyB;
import com.example.demo.config.JunitCfg;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JunitCfg.class)
public class DependencyTest {

    @Test
    public void dependencyTest(){
        //第一种方式 测试applicationContext加载bean是否成功
    }

    //第二种方式
    @Autowired
    private ApplicationContext context;

    //@Bean: 告诉Spring框架必须使用这些方法来检索bean并注入
    @Bean
    private DependencyA getDependencyA(){
        return new DependencyA();
    }

    @Bean
    private DependencyB getDependencyB(){
        return new DependencyB();
    }


    @Test
    public void dependencyTest2(){
        DependencyA deA = context.getBean(DependencyA.class);

        String message = deA.getDeB().getMessage();

        //判断两个参数是否相等 相等则程序继续向下执行; 不相等则会抛出 AssertionFailedError 异常;
        Assert.assertEquals("hello",message);

        System.out.println(message);
    }
}
