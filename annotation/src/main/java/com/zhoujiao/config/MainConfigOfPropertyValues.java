package com.zhoujiao.config;

import com.zhoujiao.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description By:属性赋值
 * @Date : Created in 10:47 2018/7/19
 * @Author : zhou jiao
 */
@Configuration
//使用propertySorce读取外部配置文件属性，保存到环境变量中
@PropertySource(value = {"classpath:/person.properties"})
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
