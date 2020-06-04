package com.iiva.demo.web.solr.controller;

import com.iiva.demo.web.solr.serivce.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solr")
public class SolrController {

    @RequestMapping("/queryUser")
    public Object queryUser(String condition){

        return solrService.queryUser(condition);
    }

    @Autowired
    private SolrService solrService;
}
