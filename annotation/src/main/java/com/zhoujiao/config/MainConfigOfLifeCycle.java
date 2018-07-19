package com.zhoujiao.config;

import com.zhoujiao.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description By:Bean的生命周期
 *      bean创建-初始化--销毁的过程
 *      容器管理bean的生命周期
 *      我们可以自定义初始化个销毁方法，容器在bean进行到当前生命周期的时候用我们自定义的初始化和销毁方法
 *  构造(对象创建)
 *      单实例,在容器启动的时候创建
 *      多实例,在每次获取的时候创建对象
 *      postProcessBeforeInitialization:在初始化之前被工作
 *      postProcessAfterInitialization;在初始化之后被工作
 *
 * 初始化:
 *      对象创建完成，赋值完成之后，调用初始化方法
 * 销毁
 *      单实例:容器关闭的时候销毁
 *      多实例:容器不会管理这个bean，容器不会调用销毁方法
 *
 *      遍历得到容器中所有beanPostProcessor，逐个执行beforeInitialization
 *      ，一旦返回null,跳出for循环，不会执行后面的BeanPostProcessor，postProcessors
 *BeanPostProcessor原理
 *
 *  populateBean(beanName,mbd,instanceWrapper);给bean进行属性赋值
 *  initializeBean 初始化
 *      {
 *      applyBeanPostProcessorsBeforeInitialization（wrappedBean，Bean） 执行前置方法
 *      invokeInitMethods(beanName,wrappedBean,mbd);执行初始化 执行自定义
 *      applyBeanPostProcessorsAfterInitialization(wrappedBean,BeanName) 执行后置
 *}
 *
 *  1.指定初始化和销毁方法
 *      通过@Bean注解指定initMethod和destroyMethod
 *  2.通过让Bean实现initializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)
 *  3 可以使用JSR250,
 *      @PostConstruct;在组件初始化完成之后执行
 *      @PreDestroy;在销毁之前使用
 *  4.BeanPostProcessor 在bean初始化前后进行一些操作
 *      postProcessBeforeInitialization:在初始化之前被工作
 *      postProcessAfterInitialization;在初始化之后被工作
 *
 *         spring底层对BeanPostProcessor的支持
 *              bean赋值，注入其他组件，@AutoWired，生命周期注解功能，@Async，xxx BeanPostProcessor
 * @Date : Created in 16:33 2018/7/17
 * @Author : zhou jiao
 */
@ComponentScan("com.zhoujiao.bean")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }



}
