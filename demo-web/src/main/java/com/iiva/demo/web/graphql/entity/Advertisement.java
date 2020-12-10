package com.iiva.demo.web.graphql.entity;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Advertisement implements Serializable {

    private Integer id;

    private String type;

    private String place;

    private String imagePath;

    private String url;

    private String publisher;

    private Date publishTime;

    public String getPublishTimeText(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(this.publishTime);
    }
}
