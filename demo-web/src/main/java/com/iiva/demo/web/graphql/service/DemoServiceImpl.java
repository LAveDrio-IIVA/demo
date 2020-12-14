package com.iiva.demo.web.graphql.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iiva.demo.web.graphql.dao.DemoDao;
import com.iiva.demo.web.graphql.entity.*;
import com.iiva.demo.web.graphql.request.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService{


    @Override
    public List<Category> getAllCategories() {

        return demoDao.getAllCategories();
    }

    @Override
    public Book getBookById(Integer id) {

        return demoDao.getBookById(id);
    }

    @Override
    public Author getAuthorById(Integer id) {

        return demoDao.getAuthorById(id);
    }

    @Override
    public List<Book> getBooksByIds(List<Integer> ids) {

        return demoDao.getBooksByIds(ids);
    }

    @Override
    public List<Book> getBooksByCategoryId(Integer categoryId) {

        return demoDao.getBooksByCategoryId(categoryId);
    }

    @Override
    public List<Book> getBooksByAuthorId(Integer authorId) {

        return demoDao.getBooksByAuthorId(authorId);
    }

    @Override
    public List<Advertisement> getAdvertisementsByTypeLatest(String type, Integer limit) {

        return demoDao.getAdvertisementsByTypeLatest(type,limit);
    }

    @Override
    public String addAuthor(AddAuthorRequest addAuthorRequest) {

        Integer result = demoDao.addAuthor(addAuthorRequest);

        if(result == 1){
            return "success";
        }
        return "fail";
    }

    @Override
    public IPage<Book> getBooksByPage(Integer page, Integer size) {

        Page<Book> pageBooks = new Page<>(page,size);
        pageBooks.setRecords(demoDao.getBooksByPage(pageBooks));
        return pageBooks;
    }

    @Autowired
    private DemoDao demoDao;
}
