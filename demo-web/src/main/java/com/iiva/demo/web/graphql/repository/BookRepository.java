package com.iiva.demo.web.graphql.repository;

import com.iiva.demo.web.graphql.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    public List<Book> findAll() {

        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setId(1);
        book1.setName("钢筋是怎样炼成的");
        book1.setAuthorId(1);
        books.add(book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setName("神秘岛");
        book2.setAuthorId(2);
        books.add(book2);

        return books;

    }
}
