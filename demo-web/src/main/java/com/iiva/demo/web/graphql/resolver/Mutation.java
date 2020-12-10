package com.iiva.demo.web.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.iiva.demo.web.graphql.request.AddAuthorRequest;
import com.iiva.demo.web.graphql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public String addAuthor(AddAuthorRequest addAuthorRequest){

        return demoService.addAuthor(addAuthorRequest);
    }

    @Autowired
    private DemoService demoService;
}
