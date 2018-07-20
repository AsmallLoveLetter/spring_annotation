package com.zhoujiao.service;

import com.zhoujiao.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @Description By:
 * @Date : Created in 11:30 2018/7/19
 * @Author : zhou jiao
 */
@Service
public class BookService {

    /*@Qualifier("bookDao1")*/
    @Autowired(required = false)
    @Inject
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao.toString());
    }
}
