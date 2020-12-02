package com.iiva.demo.web.graphql.repository;

import com.iiva.demo.web.graphql.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorRepository {

    public Author findById(int authorId) {

        Author author1 = new Author();
        author1.setId(1);
        author1.setName("保尔柯察金");

        Author author2 = new Author();
        author2.setId(2);
        author2.setName("儒勒凡尔纳");

        if(authorId == 1){

            return author1;
        }
        return author2;
    }
}
