package com.gyan.sec01.publisher;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Log4j2
public class SubscriptionImpl implements Subscription {

    private final Subscriber subscriber;
    private final Faker faker;
    public static final int MAX_ITEMS = 10;
    private int count = 0;
    private boolean isUnSubscribe;

    public SubscriptionImpl(Subscriber subscriber) {
        this.subscriber = subscriber;
        this.faker = Faker.instance();
    }

    @Override
    public void request(long requested) {
        if (isUnSubscribe) return;
        if (count + requested > MAX_ITEMS) {
            String msg = String.format("Limit exceeded!! %s items requested, but only %s remaining", requested, (MAX_ITEMS - count));
            subscriber.onError(new RuntimeException(msg));
            isUnSubscribe = true;
        }
        log.info("Requested for {} items", requested);
        for (long i = 0; i < requested && count < MAX_ITEMS; i++) {
            subscriber.onNext(faker.book().title());
            count++;
        }
        if (count == MAX_ITEMS) {
            log.info("No more data to produce.");
            subscriber.onComplete();
            isUnSubscribe = true;
        }
    }

    @Override
    public void cancel() {
        log.info("Cancelled!!");
        isUnSubscribe = true;
    }
}
