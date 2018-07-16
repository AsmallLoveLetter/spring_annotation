package com.zhoujiao.bean;

/**
 * @Description By:
 * @Date : Created in 11:17 2018/7/16
 * @Author : zhou jiao
 */

public class Persion {

    private String name;
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
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Persion() {
    }
}
