package com.arao.challenges.topics.threads.simpleextension;

import com.arao.challenges.topics.threads.simpleextension.NumberCounter;
import com.arao.challenges.topics.threads.simpleextension.Thread1;

public class ThreadMain {

    public static void main(String[] args) {
        // Create instance of Number Counter to send to the Thread
        NumberCounter counter = new NumberCounter();

        // Create 3 threads of the same instance for executing in parallel
        Thread1 t1 = new Thread1(counter);
        Thread1 t2 = new Thread1(counter);
        Thread1 t3 = new Thread1(counter);

        t1.start();
        try {
            // When we invoke the join() method on a thread, the calling thread goes into a waiting state.
            // It remains in a waiting state until the referenced thread terminates.
            t1.join();
            System.out.println("join() finished for t1 \n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // execution of thread 2 and 3
        t2.start();
        t3.start();
    }
}
