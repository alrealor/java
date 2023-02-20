package com.arao.challenges.topics.solidprinciples.dependencyinversion;

/**
 * Low-level module class
 * THIS CLASS IS BANK PROPERTY AND CANNOT BE MODIFIED
 */
public class MyBankApi {

    // Payment method through the bank API
    public void interchange() {
        System.out.println("Applying payment through bank API");
    }
}
