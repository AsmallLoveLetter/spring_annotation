package com.zhoujiao.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description By:
 * @Date : Created in 18:01 2018/7/18
 * @Author : zhou jiao
 */

@Component
public class Dog implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Dog() {
        System.out.println("dog constructor....");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
