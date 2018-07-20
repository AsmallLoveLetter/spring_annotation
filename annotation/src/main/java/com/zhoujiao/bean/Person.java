package com.zhoujiao.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Description By:
 * @Date : Created in 11:17 2018/7/16
 * @Author : zhou jiao
 */

public class Person {

    //使用value赋值
    //1.基本数据
    //2.可以写SpEl，#{}
    //3.可以写${},取出配置文件中的值，

    @Value("${person.name}")
    private String name;

    @Value("#{20-18}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
