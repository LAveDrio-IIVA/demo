package com.iiva.demo.web.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {

    private String id;

    private String time;

    private String topic;
}
