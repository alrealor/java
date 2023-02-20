package com.arao.challenges.topics.threads.simpleextension;

public class NumberCounter {

    public synchronized void syncDisplayNumbers() {
        for(int i=10; i>=0; i--) {
            System.out.println("Sync display number: " + i);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }

    public void nonSyncDisplayNumbers() {
        for(int i=10; i>=0; i--) {
            System.out.println("Non-Sync display number: " + i);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}
