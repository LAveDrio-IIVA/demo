package com.iiva.demo.web.graphql.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class SendMessageRequest implements Serializable {

    private String sender;

    private String content;

}
