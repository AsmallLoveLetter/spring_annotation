import com.zhoujiao.bean.Boss;
import com.zhoujiao.bean.Car;
import com.zhoujiao.bean.Person;
import com.zhoujiao.config.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

/**
 * @Description By:
 * @Date : Created in 11:24 2018/7/16
 * @Author : zhou jiao
 */

public class MainTest {

   @Test
   public void testConfig2() {
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
      String[] definitionNames = applicationContext.getBeanDefinitionNames();


      for (String definitionName : definitionNames) {
         System.out.println(definitionName);
      }

      Object bean = applicationContext.getBean("zhoujiao");
      Object bean1 = applicationContext.getBean("zhoujiao");
      //默认单实例 值为true
      System.out.println(bean == bean1);




   }

   /**
    * 可以在Idea或者其他工具中指定os.name 来指定环境产生 如-Dos.name = Linux
    */
   @Test
   public void testConditionnal() {
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
      String[] definitionNames = applicationContext.getBeanNamesForType(Person.class);
      //获取环境变量
      ConfigurableEnvironment environment =  applicationContext.getEnvironment();
      //获取系统
      String property = environment.getProperty("os.name");
      for (String definitionName : definitionNames) {
         System.out.println(definitionName);
      }

      System.out.println("当前系统为"+property);
   }

   @Test
   public void testImport() {
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
      String[] definitionNames = applicationContext.getBeanDefinitionNames();
      for (String definitionName : definitionNames) {
         System.out.println(definitionName);
      }

      Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
      System.out.println(colorFactoryBean.getClass());

   }

    /**
     * 生命周期测试
     */
    @Test
    public void IOCTest_LifeCycel01() {
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
//        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for (String definitionName : definitionNames) {
//            System.out.println(definitionName);
//        }
       applicationContext.close();

    }


   /**
    * 测试赋值
    */
   @Test
   public void testValues() {
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
      String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
      for (String beanDefinitionName : beanDefinitionNames) {
         System.out.println(beanDefinitionName);
      }
      Person person = (Person) applicationContext.getBean("person");
      System.out.println(person);
      ConfigurableEnvironment environment = applicationContext.getEnvironment();
      String property = environment.getProperty("person.name");
      String environmentProperty = environment.getProperty("person.age");
      System.out.println(property+"...."+environmentProperty);
   }


   @Test
   public void testAutowired() {
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
      Boss bean = applicationContext.getBean(Boss.class);
      /*BookDao bean1 = applicationContext.getBean(BookDao.class);*/
      Car bean1 = applicationContext.getBean(Car.class);
//      System.out.println(bean1);
      System.out.println(bean);
      System.out.println(bean1);
   }

   @Test
   public void testProfile() {
//      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
//      String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
//      for (String s : beanNamesForType) {
//         System.out.println(s);
//      }
      //创建一个ApplicationContext 无参
      AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
      //设置需要激活的环境
      applicationContext.getEnvironment().setActiveProfiles("test","dev");
      //设置主配置类
      applicationContext.register(MainConfigOfProfile.class);
      //启动刷新容器
      applicationContext.refresh();
      String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
      for (String s : beanNamesForType) {
         System.out.println(s);
      }
   }
}
