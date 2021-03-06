package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.iiva.demo.web.graphql.entity.Author;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    public Author author(Book book) {

        return demoService.getAuthorById(book.getAuthorId());
    }

    @Autowired
    private DemoService demoService;
}
