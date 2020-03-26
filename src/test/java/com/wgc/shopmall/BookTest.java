package com.wgc.shopmall;

import com.wgc.shopmall.model.Book;
import com.wgc.shopmall.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/25/2020
 **/

@SpringBootTest
public class BookTest {
    @Autowired
    private IBookService bookService;
    @Test
    public void listAllBooks(){
        try {
            List<Book> books = bookService.listAllBook();
            System.out.println(books.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
