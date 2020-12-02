package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.iiva.demo.web.graphql.entity.Author;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLResolver<Book> {

    @Autowired
    private AuthorRepository authorRepository;

    public Author author(Book book) {
        return authorRepository.findById(book.getAuthorId());
    }
}
