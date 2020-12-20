package com.iiva.demo.web.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    private String sender;

    private String content;

    private String time;
}
