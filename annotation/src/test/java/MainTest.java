import com.zhoujiao.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
}
