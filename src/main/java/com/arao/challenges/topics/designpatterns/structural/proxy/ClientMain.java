package com.arao.challenges.topics.designpatterns.structural.proxy;

/**
 * PROXY pattern
 *
 * This pattern lets the developers provide a substitute for another object. This is called a proxy object.
 * This helps to control the access to the original object and allows us to perform many tasks before or after the
 * request reaches the original object
 */
public class ClientMain {

    public static void main(String... args) {
        // Create instance to the proxy class
        Internet internet = new ProxyInternet();

        try {
            internet.connectTo("bimmers.com");
            internet.connectTo("suspicious.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
