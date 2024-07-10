package com.gyan.sec01.publisher;

import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Log4j2
public class PublisherImpl implements Publisher<String> {
    @Override
    public void subscribe(Subscriber<? super String> s) {
        Subscription subscription = new SubscriptionImpl(s);
        s.onSubscribe(subscription);
    }
}
