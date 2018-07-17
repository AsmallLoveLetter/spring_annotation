package com.zhoujiao.config;

import com.zhoujiao.bean.Person;
import com.zhoujiao.conditional.LinuxConditional;
import org.springframework.context.annotation.*;

/**
 * @Description By:配置类
 * @Date : Created in 11:21 2018/7/16
 * @Author : zhou jiao
 */
@Configuration //配置类
//类中组件统一设置 满足当前条件,这个类中配置的所有Bean注册才能生效
@Conditional({LinuxConditional.class})
@ComponentScan(value = "com.zhoujiao",includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)  //自动扫描注解   value指定要扫面的包
//excludeFIlters = Filter[] 指定扫面的时候按照什么规则排除那些组件
//includeFilters = Filter[] 指定扫描的时候只需要包含那些组件
// FilterType.ANNOTATION 按照注解
// FilterType.ASSIGNABLE_TYPE 按照给定的类型
public class MainConfig {

    //给容器中注册一个Bean,Id默认是方法名
    @Bean(name = "persion")//     指定id
    public Person persion() {
        return new Person("list", 20);
    }

    @Bean(name = "lisi")
    public Person personlist() {
        return new Person("lisi", 20);
    }
}
