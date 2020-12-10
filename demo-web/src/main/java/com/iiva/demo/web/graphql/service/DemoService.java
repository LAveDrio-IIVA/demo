package com.iiva.demo.web.graphql.service;

import com.iiva.demo.web.graphql.entity.Advertisement;
import com.iiva.demo.web.graphql.entity.Author;
import com.iiva.demo.web.graphql.entity.Book;
import com.iiva.demo.web.graphql.entity.Category;
import com.iiva.demo.web.graphql.request.AddAuthorRequest;

import java.util.List;

public interface DemoService {

    List<Category> getAllCategories();

    Book getBookById(Integer id);

    Author getAuthorById(Integer id);

    List<Book> getBooksByIds(List<Integer> ids);

    List<Book> getBooksByCategoryId(Integer categoryId);

    List<Book> getBooksByAuthorId(Integer authorId);

    List<Advertisement> advertisementsByTypeLatest(String type, Integer limit);

    String addAuthor(AddAuthorRequest addAuthorRequest);
}
