package com.iiva.demo.web.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class Film implements Serializable {

    @ApiModelProperty(value = "电影id")
    private String id;

    @ApiModelProperty(value = "电影名字")
    private String name;

    @ApiModelProperty(value = "电影描述")
    private String description;

}
