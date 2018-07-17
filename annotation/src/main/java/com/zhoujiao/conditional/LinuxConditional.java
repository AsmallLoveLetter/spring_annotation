package com.zhoujiao.conditional;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description By:判断是否linux系统
 * @Date : Created in 16:56 2018/7/16
 * @Author : zhou jiao
 */

public class LinuxConditional implements Condition {

    /**
     *
     * @param context 判断条件使用的上下文
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取到ioc使用的工程
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取当前环境信息
        Environment environment = context.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        //是否注册了zhoujiao这个bean
        Boolean zhoujiao = registry.containsBeanDefinition("zhoujiao");

        String property = environment.getProperty("os.name");
        if (property.contains("Linux"))
            return true;
        return false;
    }
}
