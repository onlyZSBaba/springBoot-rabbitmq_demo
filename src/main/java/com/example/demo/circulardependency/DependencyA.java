package com.example.demo.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/28
 */
@Component
public class DependencyA {

    private DependencyB deB;

    //第一种方式: 在两个互相依赖的bean任意一个构造方法中使用@Lazy 延迟加载另一个Bean;
    /*@Autowired
    public DependencyA(@Lazy DependencyB deB) {
        this.deB = deB;
    }*/

    //第二种方式: 相互依赖的bean用set方式注入bean 并使用@Autowired注解;
    @Autowired
    public void setDeB(DependencyB deB) {
        this.deB = deB;
    }

    public DependencyB getDeB() {
        return deB;
    }
}
