package com.zhoujiao.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description By:
 * @Date : Created in 14:14 2018/7/19
 * @Author : zhou jiao
 */
@Component
public class Boss {

    private Car car;


    public Boss(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

}
