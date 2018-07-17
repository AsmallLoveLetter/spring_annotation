package com.zhoujiao.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description By:颜色工厂 创建spirng定义的FactoryBean
 * @Date : Created in 14:35 2018/7/17
 * @Author : zhou jiao
 */
public class ColorFactoryBean implements FactoryBean<ColorFactory> {

    /**
     *
     * @return 返回一个指定的Bean
     * @throws Exception
     */
    @Override
    public ColorFactory getObject() throws Exception {
        System.out.println("我是Factory创建的color");
        return new ColorFactory();
    }

    /**
     *返回的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {

        return ColorFactory.class;
    }

    /**
     * 指定是否单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
