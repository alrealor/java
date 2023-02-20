package com.arao.challenges.topics.functionalinterface;


abstract class AC1 {

    abstract void methodAC1();

    void method2AC1() {
        System.out.println("Hi from Abstract Class method 2");
    }
}

interface I1 {
    default void hi() {
        System.out.println("Hi from interface 1");
    }
}

interface I2 {
    default void hi() {
        System.out.println("Hi from interface 2");
    }
}

@FunctionalInterface
interface I3 extends I1, I2 {
    int methodI3(int x);

    @Override
    default void hi() {
        System.out.println("Hi from interface 3");
    }
}

public class Tester extends AC1 implements I3 {

    public static void main(String[] args) {
        I1 t = new Tester();
    }

    @Override
    public int methodI3(int x) {
        return 0;
    }

    @Override
    void methodAC1() {

    }
}
