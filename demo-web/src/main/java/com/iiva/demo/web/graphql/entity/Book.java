package com.iiva.demo.web.graphql.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    private int id;

    private String name;

    private int authorId;
}
