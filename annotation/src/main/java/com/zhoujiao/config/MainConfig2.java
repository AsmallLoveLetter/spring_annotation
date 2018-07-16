package com.zhoujiao.config;

import com.zhoujiao.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Description By:
 * @Date : Created in 15:34 2018/7/16
 * @Author : zhou jiao
 */
@Configuration
public class MainConfig2 {


    /**
     * prototype 多实例的。 ioc容器启动并不会去调用方法创建对象放在容器中
     * 默认 singleton 单实例的 ,ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从
     * 容器中(map.get)拿
     * request 同一次请求创建一个实例
     * session 同一个session创建一个实例
     *
     *
     * 懒加载 :
     *      单实例bean ,默认在容器启动的时候创建对象
     *      懒加载,容器启动不创建对象.第一次使用(获取)Bean创建对象
     *
     * @return
     */
    @Scope("prototype")
    @Lazy
    @Bean(name = "zhoujiao")
    public Person person() {
        System.out.println("添加实体Bean");
        return new Person("周骄", 28);
    }

    /**
     * Conditional ,按照一定的条件进行判断，满足条件给容器中注册bean
     */
    public Person personConditional() {
        return new Person("Bill", 100);
    }
}
