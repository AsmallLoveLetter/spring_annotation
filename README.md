# spring_annotation
##IOC
###IOC-组件注册
1.自定义配置类 @Configuration
2.导入组件 @Import 
    1.直接写入类 ({Dog.class})
    2.实现importSelector接口 自定义逻辑返回要导入的组件
    3.实现ImportBeanDefinitionRegistrar接口 手动添加bean至容器
    4.实现FactoryBean接口
3.满足条件注册@Conditional
4.包扫描 @ComponentScan
5.实例类型 @Scope 
6.懒加载 @Lazy
7.添加实例到容器 @Bean

###IOC-生命周期
  1.指定初始化和销毁方法     通过@Bean注解指定initMethod和destroyMethod
  2.通过让Bean实现initializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑)
  3 可以使用JSR250,
       @PostConstruct;在组件初始化完成之后执行
       @PreDestroy;在销毁之前使用
  4.BeanPostProcessor 在bean初始化前后进行一些操作
       postProcessBeforeInitialization:在初始化之前被工作
       postProcessAfterInitialization;在初始化之后被工作
          spring底层对BeanPostProcessor的支持
               bean赋值，注入其他组件，@AutoWired，生命周期注解功能，@Async，xxx BeanPostProcessor
###IOC-属性赋值
1 使用@Value赋值:1、基本数据 2,、可以写SpEl表达式#{}3、可以写${}
2 @PropertySource加载配置文件:读取出来的值中文乱码时可改变文件编码为UTF-8重新编译即可
配置文件中的值默认都加入在了环境变量中
###IOC-自动装配
1.1.@Autowired 自动注入 required属性指定是否必需
            1.默认优先按照类型去容器中查看对应的组件:application.getBeen(BookDao.class)
            2.@Qualifier指定需要装配的组件id
            3.@Primary,容器装配的时候首选装配
  2.spring还支持@Resource和@Inject注解----->JSR330[java规范的注解]
            1.@Resource:
                    可以和Autowired实现自动装配功能，默认是按照组件名称装配的
            2.@Inject:
                    需要导入java.inject的包,和Autowired的功能一样 没有required属性
   AutowiredAnnotationBeanPostProcessor类完成自动装配的功能    
     
   3.
   Autowired标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值，方法使用的参数
   自定义类型的值从ioc容器中获取。@Bean加上方法参数，参数从容器中获取，默认不写@Autowired。也能实现自动装配
            标注在构造器上，如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，容器还是可以完成自动装配
            标注在参数中
            
   4.自定义组件想要使用Spring容器底层的一些组件，(ApplicationContext,BeanFactory,xxx)
        自定义组件实现xxxxAware,在创建对象的时候，会调用这个接口规定的方法注入相关组件
        xxxAware,功能时使用xxxProcessor来实现的 Processor后置处理器
2.@Profile 使用@Profile表示在特定的环境中注册组件至容器
        设定环境的方式:1.使用命令行参数:-Dspring.profiles.active= 指定激活哪一个环境
                        2.使用application写入环境变量
                          //创建一个ApplicationContext 无参
                              AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
                              //设置需要激活的环境
                              applicationContext.getEnvironment().setActiveProfiles("test","dev");
                              //设置主配置类
                              applicationContext.register(MainConfigOfProfile.class);
                              //启动刷新容器
                              applicationContext.refresh();
                        3.当@Profile标注在类上时，只有指定的环境被激活，类中的配置才会生效
                        
##AOP
