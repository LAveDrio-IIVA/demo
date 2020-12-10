package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.entity.Category;
import com.iiva.demo.web.graphql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryResolver implements GraphQLResolver<Category> {

    public List<Book> books(Category category){

        return demoService.getBooksByCategoryId(category.getId());
    }

    @Autowired
    private DemoService demoService;
}
