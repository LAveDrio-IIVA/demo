package com.iiva.demo.web.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo implements Serializable {

    private long total;

    private long size;

    private long current;
}
