package com.iiva.demo.web.graphql.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iiva.demo.web.graphql.dao.DemoDao;
import com.iiva.demo.web.graphql.entity.*;
import com.iiva.demo.web.graphql.event.SendMessageEvent;
import com.iiva.demo.web.graphql.request.AddAuthorRequest;
import com.iiva.demo.web.graphql.request.SendMessageRequest;
import com.iiva.demo.web.graphql.support.DemoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @Override
    public String sendMessage(SendMessageRequest sendMessageRequest) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Message message = new Message(sendMessageRequest.getSender(),sendMessageRequest.getContent(),simpleDateFormat.format(new Date()));

        SendMessageEvent sendMessageEvent = new SendMessageEvent(this,message);

        applicationContext.publishEvent(sendMessageEvent);

        return "success";
    }

    @Override
    public List<School> getAllSchools() {

        return demoDao.getAllSchools();
    }

    @Override
    public List<Teacher> getTeachersBySchoolId(Integer schoolId) {

        return demoDao.getTeachersBySchoolId(schoolId);
    }

    @Override
    public List<List<Teacher>> getTeachersBySchoolIds(List<Integer> schoolIds) {

        List<Teacher> teachers = demoDao.getTeachersBySchoolIds(schoolIds);

        return demoSupport.combineTeachersBySchoolId(teachers);
    }

    @Override
    public List<Integer> getSchoolIds() {

        return demoDao.getSchoolIds();
    }

    @Autowired
    private DemoDao demoDao;

    @Resource
    private ApplicationContext applicationContext;

    @Autowired
    private DemoSupport demoSupport;

}
