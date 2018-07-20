package com.zhoujiao.controller;

import com.zhoujiao.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description By:
 * @Date : Created in 11:30 2018/7/19
 * @Author : zhou jiao
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
