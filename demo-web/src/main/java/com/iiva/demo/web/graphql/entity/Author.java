package com.iiva.demo.web.graphql.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Author implements Serializable {

    private Integer id;

    private String name;

}
