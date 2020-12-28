package com.iiva.demo.web.graphql.resolver.root;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.iiva.demo.web.graphql.entity.*;
import com.iiva.demo.web.graphql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class Query implements GraphQLQueryResolver {

    public CompletableFuture<List<Category>> categories() {

        return CompletableFuture.supplyAsync(() ->
                demoService.getAllCategories());
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

    public CompletableFuture<List<Advertisement>> getAdvertisementsByTypeLatest(String type,Integer limit){

        return CompletableFuture.supplyAsync(() ->
                demoService.getAdvertisementsByTypeLatest(type,limit));
    }

    public BooksByPage getBooksByPage(Integer page,Integer size){

        IPage<Book> iPageBooks = demoService.getBooksByPage(page,size);

        return new BooksByPage(iPageBooks.getRecords(),new PageInfo(iPageBooks.getTotal(),iPageBooks.getSize(),iPageBooks.getCurrent()));
    }

    public List<School> schools() {

        return demoService.getAllSchools();
    }

    @Autowired
    private DemoService demoService;

}
