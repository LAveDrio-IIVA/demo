package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.iiva.demo.web.graphql.entity.Author;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    public List<Book> books(Author author){

        return demoService.getBooksByAuthorId(author.getId());
    }

    @Autowired
    private DemoService demoService;
}
