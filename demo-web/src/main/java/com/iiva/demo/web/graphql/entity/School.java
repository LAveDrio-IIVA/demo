package com.iiva.demo.web.graphql.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class School {

    private Integer id;

    private String name;

    // To test FieldResolverScanner rule
//    public List<Teacher> teachers(){
//
//        Teacher teacher = new Teacher();
//        teacher.setName("李博博");
//
//        List <Teacher> a = new ArrayList<Teacher>();
//        a.add(teacher);
//
//        return a;
//    }
}
