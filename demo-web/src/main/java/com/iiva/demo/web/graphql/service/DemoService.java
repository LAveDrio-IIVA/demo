package com.iiva.demo.web.graphql.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.iiva.demo.web.graphql.entity.*;
import com.iiva.demo.web.graphql.request.AddAuthorRequest;
import com.iiva.demo.web.graphql.request.SendMessageRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DemoService {

    List<Category> getAllCategories();

    Book getBookById(Integer id);

    Author getAuthorById(Integer id);

    List<Book> getBooksByIds(List<Integer> ids);

    List<Book> getBooksByCategoryId(Integer categoryId);

    List<Book> getBooksByAuthorId(Integer authorId);

    List<Advertisement> getAdvertisementsByTypeLatest(String type, Integer limit);

    String addAuthor(AddAuthorRequest addAuthorRequest);

    IPage<Book> getBooksByPage(Integer page, Integer size);

    String sendMessage(SendMessageRequest sendMessageRequest);

    List<School> getAllSchools();

    List<Teacher> getTeachersBySchoolId(Integer schoolId);

    Map<Integer, List<Teacher>> getTeachersBySchoolIds(Set<Integer> schoolIds);

    List<Integer> getSchoolIds();

}
