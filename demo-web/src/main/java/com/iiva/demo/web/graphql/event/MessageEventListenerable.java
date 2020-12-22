package com.iiva.demo.web.graphql.event;

public interface MessageEventListenerable {

    void messageEvent(SendMessageEvent sendMessageEvent);
}
