package com.zhoujiao.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description By:Profile:指定组件在哪个环境中才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *     Spring为我们提供的可以根据当前环境，动态的激活的切换一系列组件的功能
 *      1.加了这个环境的bean，只有这个环境被激活，对应的组件才会被注册到容器中
 *      2.写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 *      3.没有标注环境变量的bean，在任何环境中都能生效
 * @Date : Created in 10:15 2018/7/20
 * @Author : zhou jiao
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    @Value("${db.driverClass}")
    private String driverClass;

    //使用spring提供的值解析器
    private StringValueResolver stringValueResolver;

    @Profile("test")
    @Bean(name = "testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        //解析器解析
        String stringValue = stringValueResolver.resolveStringValue("${db.driverClass}");
        comboPooledDataSource.setDriverClass(stringValue);
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean(name = "devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("pro")
    @Bean(name = "proDataSource")
    public DataSource dataSourcePro(@Value("${db.password}")String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/pro");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }
}
