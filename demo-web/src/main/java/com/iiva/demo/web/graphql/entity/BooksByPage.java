package com.iiva.demo.web.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksByPage implements Serializable {

    private List<Book> books;

    private PageInfo pageInfo;

}
