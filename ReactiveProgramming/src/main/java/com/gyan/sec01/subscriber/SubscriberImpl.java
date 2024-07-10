package com.gyan.sec01.subscriber;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Log4j2
public class SubscriberImpl implements Subscriber<String> {
    @Getter
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
    }

    @Override
    public void onNext(String s) {
        log.info("received: {}", s);
    }

    @Override
    public void onError(Throwable t) {
        log.error("Error!!", t);
    }

    @Override
    public void onComplete() {
        log.info("Completed!");
    }
}
