package com.zhoujiao.config;

import com.zhoujiao.bean.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description By:
 * @Date : Created in 15:34 2018/7/16
 * @Author : zhou jiao
 */
@Configuration
public class MainConfig2 {


    /**
     * prototype 多实例的
     * 默认 singleton 单实例的 ,ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从
     * 容器中(map.get)拿
     * request 同一次请求创建一个实例
     * session 同一个session创建一个实例
     * @return
     */
    @Scope("prototype")
    @Bean(name = "zhoujiao")
    public Persion person() {
        return new Persion("周骄", 28);
    }
}
