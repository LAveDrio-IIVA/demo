package com.iiva.demo.web.graphql.entity;

import lombok.Data;

import java.io.Serializable;

public class Book implements Serializable {

    private Integer id;

    private String name;

    private Integer categoryId;

    private Integer authorId;

    // get、set是为了测试并发（graphql默认是不会并发的,需要自定义线程）
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
}
