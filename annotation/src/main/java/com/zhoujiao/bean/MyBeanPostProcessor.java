package com.zhoujiao.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description By:后置处理器，初始化前后进行处理
 * @Date : Created in 18:26 2018/7/18
 * @Author : zhou jiao
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("前容器名称"+beanName+"...."+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后容器名称"+beanName+"...."+bean);
        return bean;
    }
}
