package com.iiva.demo.web.graphql.resolver.root;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.iiva.demo.web.graphql.entity.NewsRelease;
import com.iiva.demo.web.graphql.service.DemoService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Subscription implements GraphQLSubscriptionResolver {

    public Publisher<NewsRelease> newsRelease() {

        return null;
    }

    @Autowired
    private DemoService demoService;

}
