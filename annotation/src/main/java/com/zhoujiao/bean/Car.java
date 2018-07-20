package com.zhoujiao.bean;

import org.springframework.stereotype.Component;

/**
 * @Description By:
 * @Date : Created in 16:37 2018/7/17
 * @Author : zhou jiao
 */
@Component
public class Car {

    public Car() {
        System.out.println("car constructor.....");
    }

    public void init() {
        System.out.println("cat....init...");
    }

    public void destroy() {
        System.out.println("car...destroy....");
    }
}
