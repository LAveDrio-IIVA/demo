package com.iiva.demo.web.solr.serivce;

import com.alibaba.fastjson.JSON;
import com.iiva.demo.web.solr.entity.User;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.noggit.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SolrServiceImpl implements SolrService{


    @Override
    public List<User> queryUser(String condition) {

        List<User> users = new ArrayList<>();
        SolrQuery solrQuery = new SolrQuery();

        //设置默认搜索的域
        solrQuery.set("df", "username");
        solrQuery.setQuery(condition);
        //高亮显示
        solrQuery.setHighlight(true);
        //设置高亮显示的域
        solrQuery.addHighlightField("description");
        //高亮显示前缀
        solrQuery.setHighlightSimplePre("<font color='red'>");
        //后缀
        solrQuery.setHighlightSimplePost("</font>");

        try {

            QueryResponse queryResponse = solrClient.query(solrQuery);
            if (queryResponse == null){

                return null;
            }

            SolrDocumentList solrDocumentList = queryResponse.getResults();

            if (solrDocumentList.isEmpty()){

                return null;
            }
            //获取高亮
            Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();

            for (SolrDocument solrDocument : solrDocumentList){

                User book;

                List<String> list = map.get(solrDocument.get("id")).get("description");

                if (!CollectionUtils.isEmpty(list)){

                    solrDocument.setField("username",list.get(0));
                }

                String userStr = JSONUtil.toJSON(solrDocument);

                book = JSON.parseObject(userStr,User.class);

                users.add(book);
            }
        } catch (SolrServerException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return users;
    }

    @Autowired
    private SolrClient solrClient;
}
