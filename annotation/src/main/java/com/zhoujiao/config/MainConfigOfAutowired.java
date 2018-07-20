package com.zhoujiao.config;

import com.zhoujiao.bean.Red;
import com.zhoujiao.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Description By:自动装配
 *              spring利用依赖注入(DI),完成IOC容器中各个组件的依赖关系赋值
 *             @Autowired required指定是否必需组件
 *                  1.默认优先按照类型找对应的组件:applicationContext.getBean(BookDao.class)
 *                  2.使用@Qualifier（"bookDao1"），指定装配的组件
 *                  3.@Primary，让spring默认使用首选的bean
 * @Date : Created in 11:28 2018/7/19
 * @Author : zhou jiao
 */
@Configuration
@ComponentScan({"com.zhoujiao.dao","com.zhoujiao.service","com.zhoujiao.controller","com.zhoujiao.bean"})
@Import(Red.class)
public class MainConfigOfAutowired {


    @Bean(name = "bookDao1")
    public BookDao bookDao() {
        return new BookDao(2);
    }
}
