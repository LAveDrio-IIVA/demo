package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.iiva.demo.web.graphql.entity.Advertisement;
import com.iiva.demo.web.graphql.entity.Author;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.entity.Category;
import com.iiva.demo.web.graphql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Category> categories() {

        return demoService.getAllCategories();
    }

    public Book book(Integer id) {

        return demoService.getBookById(id);
    }

    public Author author(Integer id) {

        return demoService.getAuthorById(id);
    }

    public List<Book> booksByIds(List<Integer> ids) {

        return demoService.getBooksByIds(ids);
    }

    public List<Advertisement> advertisementsByTypeLatest(String type,Integer limit){

        return demoService.advertisementsByTypeLatest(type,limit);
    }

    @Autowired
    private DemoService demoService;

}
