package com.arao.challenges.topics.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestObserverMain {

    public static void main(String[] args) {

        PCLNewsAgency observable = new PCLNewsAgency();
        List<PCLNewsChannel> observers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            observers.add(new PCLNewsChannel()); // create and add observer to the list
            observable.addPropertyChangeListener(observers.get(i)); // add observer to the observable listener
        }

        observable.setNews("value");
        observable.setNews("next value");
        observable.setNews("final value"); // observer containing the last value from observable

        AtomicInteger count = new AtomicInteger(1);
        observers.forEach(item ->
                System.out.println("Observer " + count.getAndIncrement() + ": " + item.getNews()));
    }
}
