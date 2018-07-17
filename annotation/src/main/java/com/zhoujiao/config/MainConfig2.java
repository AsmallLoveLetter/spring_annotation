package com.zhoujiao.config;

import com.zhoujiao.bean.Color;
import com.zhoujiao.bean.ColorFactoryBean;
import com.zhoujiao.bean.Person;
import com.zhoujiao.bean.Red;
import com.zhoujiao.conditional.LinuxConditional;
import com.zhoujiao.conditional.WindowsConditional;
import com.zhoujiao.selector.MyImportBeanDefinitionRegistrar;
import com.zhoujiao.selector.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @Description By:
 * @Date : Created in 15:34 2018/7/16
 * @Author : zhou jiao
 */
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import 快速导入组件 id为全类名
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
     * Conditional({Conditional}) ,按照一定的条件进行判断，满足条件给容器中注册bean
     */
    @Conditional({WindowsConditional.class})
    @Bean(name = "bill")
    public Person personConditional() {
        return new Person("Bill", 100);
    }

    @Conditional({LinuxConditional.class})
    @Bean(name = "linus")
    public Person personConditional1() {
        return new Person("linus", 48);
    }

    /**
     * 给容器中添加组件
     * 1.包扫面+组件标注注解(@Controller/@Service/@Repository/@Component)
     * 2.@Bean[导入的第三方包里面的组件]
     * 3.@Import[快速给容器中导入一个组件] id默认为全类名
     *
     * @Import({})直接安装类名进行导入
     * @ImportSelector;返回需要导入的
     * @ImportBeanDefinitionRegistrar;手动导入bean到容器中
     * 4.使用Spring提供的FactoryBean(工厂Bean)
     *  1.默认获取得到是工厂bean调用Object创建的对象
     *  2.要获取工厂Bean本身，我们需要给id前面加一个& 是由BeanFactory定义的
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
