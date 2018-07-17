package com.zhoujiao.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description By:自定义逻辑返回要导入的组件
 * @Date : Created in 17:40 2018/7/16
 * @Author : zhou jiao
 */
public class MyImportSelector implements ImportSelector {

    //返回值就是导入到容器中的组件全类名

    /**
     *
     * @param importingClassMetadata;当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /*importingClassMetadata.get`*/
        return new String[]{"com.zhoujiao.bean.Blue","com.zhoujiao.bean.Yellow"};
    }
}
