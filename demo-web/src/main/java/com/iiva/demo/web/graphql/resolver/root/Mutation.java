package com.iiva.demo.web.graphql.resolver.root;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.iiva.demo.web.graphql.entity.Message;
import com.iiva.demo.web.graphql.event.SendMessageEvent;
import com.iiva.demo.web.graphql.request.AddAuthorRequest;
import com.iiva.demo.web.graphql.request.SendMessageRequest;
import com.iiva.demo.web.graphql.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public String addAuthor(AddAuthorRequest addAuthorRequest){

        return demoService.addAuthor(addAuthorRequest);
    }

    public String sendMessage(SendMessageRequest sendMessageRequest){

        return demoService.sendMessage(sendMessageRequest);
    }


    @Autowired
    private DemoService demoService;
}
