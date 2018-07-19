package com.zhoujiao.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Description By:
 * @Date : Created in 17:39 2018/7/18
 * @Author : zhou jiao
 */
@Component
public class Cat implements InitializingBean,DisposableBean {

    public Cat() {
        System.out.println("cat constructor....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }
}
