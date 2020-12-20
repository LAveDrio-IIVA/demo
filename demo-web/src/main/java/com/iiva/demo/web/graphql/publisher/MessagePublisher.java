package com.iiva.demo.web.graphql.publisher;

import com.iiva.demo.web.graphql.entity.Message;
import com.iiva.demo.web.graphql.event.SendMessageEvent;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import lombok.Data;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Data
@Component
public class MessagePublisher {

    private final Flowable<Message> publisher;

    public MessagePublisher() {

        Observable<Message> messageUpdateObservable = Observable.create(
                emitter -> {

                    MessageEventListener messageEventListener = new MessageEventListener(){

                        @EventListener
                        public void messageEvent(SendMessageEvent sendMessageEvent) {

                            System.out.println(sendMessageEvent.getMessage());
                            emitter.onNext(sendMessageEvent.getMessage());
                        }
                    };
                }
        );

        ConnectableObservable<Message> connectableObservable = messageUpdateObservable
                .share().publish();
        connectableObservable.connect();

        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

}

@Component
class MessageEventListener {

}
