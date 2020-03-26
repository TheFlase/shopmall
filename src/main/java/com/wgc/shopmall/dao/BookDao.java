package com.wgc.shopmall.dao;

import com.wgc.shopmall.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/25/2020
 **/
@Repository
public interface BookDao {
    List<Book> listAllBook();
}
