package com.example.demo.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Z
 * @version : 1.0
 * @Date : 2020/6/28
 */
@Component
public class DependencyB {

    private DependencyA deA;

    //第一种方式
    /*@Autowired
    public DependencyB(DependencyA deA) {
        this.deA = deA;
    }*/

    private String message="hello";

    //第二种方式
    @Autowired
    public void setDeA(DependencyA deA) {
        this.deA = deA;
    }

    public String getMessage() {
        return message;
    }
}
