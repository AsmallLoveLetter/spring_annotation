package com.zhoujiao.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @Description By:
 * @Date : Created in 17:37 2018/7/16
 * @Author : zhou jiao
 */

public class Red implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    /**
     * ico容器
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc"+applicationContext);
        this.applicationContext = applicationContext;
    }

    /**
     * 容器指定的bean的名称
     * @param name
     */
    @Override
    public void setBeanName(String name) {

        System.out.println("当前bean的名称"+name);
    }


    /**
     * Spring提供的字符串解析器
     * @param resolver
     */
    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String resolveStringValue = resolver.resolveStringValue("你好${os.name} 我是#{20*18}");
        System.out.println("解析完成的值"+resolveStringValue);
    }
}
