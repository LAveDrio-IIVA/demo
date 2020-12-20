package com.iiva.demo.web.graphql.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddAuthorRequest implements Serializable {

    private Integer id;

    private String name;
}
