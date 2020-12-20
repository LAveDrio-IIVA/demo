package com.iiva.demo.web.graphql.resolver.root;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import com.iiva.demo.web.graphql.entity.Message;
import com.iiva.demo.web.graphql.entity.News;
import com.iiva.demo.web.graphql.publisher.MessagePublisher;
import com.iiva.demo.web.graphql.publisher.NewsPublisher;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Subscription implements GraphQLSubscriptionResolver {

    public Publisher<News> receiveNews() {

        return newsPublisher.getPublisher();
    }

    public Publisher<Message> receiveMessage() {

        return messagePublisher.getPublisher();
    }

    @Autowired
    private NewsPublisher newsPublisher;

    @Autowired
    private MessagePublisher messagePublisher;

    Subscription(NewsPublisher newsPublisher){

        this.newsPublisher = newsPublisher;
        this.messagePublisher = messagePublisher;
    }

}
