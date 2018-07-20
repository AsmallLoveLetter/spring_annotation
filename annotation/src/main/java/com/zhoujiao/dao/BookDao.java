package com.zhoujiao.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @Description By:默认类名小写作为实例的名称
 * @Date : Created in 11:29 2018/7/19
 * @Author : zhou jiao
 */
@Repository
@Primary
public class BookDao {

    private int label = 1;

    public BookDao() {
    }

    public BookDao(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label=" + label +
                '}';
    }
}
