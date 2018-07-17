import com.zhoujiao.bean.Person;
import com.zhoujiao.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

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
}
