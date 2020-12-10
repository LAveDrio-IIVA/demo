package com.iiva.demo.web.graphql.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {

    private Integer id;

    private String name;

}
