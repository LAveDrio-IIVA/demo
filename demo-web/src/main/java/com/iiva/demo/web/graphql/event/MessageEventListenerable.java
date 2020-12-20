package com.iiva.demo.web.graphql.event;

import org.springframework.context.event.EventListener;

public interface MessageEventListenerable {

    @EventListener
    void messageEvent(SendMessageEvent sendMessageEvent);
}
