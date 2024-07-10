package com.gyan.sec01;

import com.gyan.sec01.publisher.PublisherImpl;
import com.gyan.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.time.Duration;

public class MainSec01 {
    public static void main(String[] args) {
        try {
            demo3();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    private static void demo1(){
        Publisher publisher = new PublisherImpl();
        Subscriber subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }
    private static void demo2() throws InterruptedException {
        Publisher publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(4);
        Thread.sleep(Duration.ofSeconds(2));

    }
    private static void demo3() throws InterruptedException {
        Publisher publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().cancel();
        subscriber.getSubscription().request(3);
    }
    private static void demo4() throws InterruptedException {
        Publisher publisher = new PublisherImpl();
        SubscriberImpl subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }
}
