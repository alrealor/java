package com.arao.challenges.topics.solidprinciples.dependencyinversion;

public class MyBankPaymentAdapter implements PaymentProcessor {

    private MyBankApi myBankApi;

    public MyBankPaymentAdapter(MyBankApi myBankApi) {
        this.myBankApi = myBankApi;
    }

    @Override
    public void pay() {
        this.myBankApi.interchange();
    }
}
