package com.arao.challenges.topics.threads.simpleextension;

import com.arao.challenges.topics.threads.simpleextension.NumberCounter;

public class Thread2 extends Thread {

    NumberCounter counter;

    public Thread2 (NumberCounter counter) {
        this.counter = counter;
    }

    public void run() {
        this.counter.nonSyncDisplayNumbers();
    }
}
