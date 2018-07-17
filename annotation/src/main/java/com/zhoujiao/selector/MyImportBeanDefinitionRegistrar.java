package com.zhoujiao.selector;

import com.zhoujiao.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description By:手动添加bean至容器
 * @Date : Created in 17:57 2018/7/16
 * @Author : zhou jiao
 */

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry 把所有需要添加到容器中的bean，调用BeanDefinitionRegistry的registerBeanDefinition进行注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.zhoujiao.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.zhoujiao.bean.Blue");
        if (red && blue) {
            //指定Bean的定义信息，(Bean的类型)
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个Bean,指定bean名
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
