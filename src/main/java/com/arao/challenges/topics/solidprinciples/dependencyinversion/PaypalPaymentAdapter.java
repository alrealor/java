package com.arao.challenges.topics.solidprinciples.dependencyinversion;

public class PaypalPaymentAdapter implements PaymentProcessor {

    private PaypalApi paypalApi;

    public PaypalPaymentAdapter(PaypalApi paypalApi) {
        this.paypalApi = paypalApi;
    }

    @Override
    public void pay() {
        this.paypalApi.changePayment();
    }
}
