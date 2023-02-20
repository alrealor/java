package com.arao.challenges.topics.solidprinciples.dependencyinversion;

/**
 * Class from high-level module that must depends on abstractions instead of a low-level module class
 */
public class Store {

    private PaymentProcessor paymentProcessor;

    public Store(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    // Payment method from store
    public void processingPayment() {
        this.paymentProcessor.pay();
    }
}
