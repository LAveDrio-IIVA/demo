package com.iiva.demo.web.graphql.publisher;

import com.google.common.base.Charsets;
import com.iiva.demo.web.graphql.entity.News;
import io.reactivex.*;
import io.reactivex.observables.ConnectableObservable;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Data
@Component
public class NewsPublisher {

    private final Flowable<News> publisher;

    public NewsPublisher() {
        Observable<News> newsUpdateObservable = Observable.create(
                emitter -> {

                    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
                    executorService.scheduleAtFixedRate(newTick(emitter), 0, 2, TimeUnit.SECONDS);
                }
        );

        ConnectableObservable<News> connectableObservable = newsUpdateObservable
                .share().publish();
        connectableObservable.connect();

        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

    private Runnable newTick(ObservableEmitter<News> emitter) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return () -> {
            try {
                emitter.onNext(new News(UUID.randomUUID().toString(), simpleDateFormat.format(new Date()),fetchRandomTopic()));
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        };

    }

    private String fetchRandomTopic(){

        Properties prop;
        String value = null;

        try {

            EncodedResource encodedResource = new EncodedResource(new ClassPathResource("dic/newsTopic.properties"), Charsets.UTF_8);
            prop = PropertiesLoaderUtils.loadProperties(encodedResource);

            int lineNum = (int)(Math.random()*100);
            value = prop.getProperty(lineNum + "");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

}
