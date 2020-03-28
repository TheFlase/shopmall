package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.dao.BookDao;
import com.wgc.shopmall.model.Book;
import com.wgc.shopmall.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author wgc
 * @Description
 * @Date 3/25/2020
 **/
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> listAllBook() {
        return bookDao.listAllBook();
    }
}
