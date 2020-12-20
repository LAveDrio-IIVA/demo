package com.iiva.demo.web.graphql.event;

import com.iiva.demo.web.graphql.entity.Message;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

@Getter
@Setter
public class SendMessageEvent extends ApplicationEvent implements Serializable {

    private Message message;

    public SendMessageEvent(Object source,Message message){

        super(source);
        this.message = message;
    }


}
