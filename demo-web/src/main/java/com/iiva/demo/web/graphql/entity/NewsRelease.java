package com.iiva.demo.web.graphql.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewsRelease implements Serializable {

    private String time;

    private String topic;
}
