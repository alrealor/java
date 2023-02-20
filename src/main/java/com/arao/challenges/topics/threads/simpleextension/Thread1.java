package com.arao.challenges.topics.threads.simpleextension;

import com.arao.challenges.topics.threads.simpleextension.NumberCounter;

public class Thread1 extends Thread {

    NumberCounter counter = null;

    public Thread1(NumberCounter counter) {
        this.counter = counter;
    }

    public void run() {
        this.counter.nonSyncDisplayNumbers();
    }
}
