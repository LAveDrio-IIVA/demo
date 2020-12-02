package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> books() {
        return bookRepository.findAll();
    }
}
