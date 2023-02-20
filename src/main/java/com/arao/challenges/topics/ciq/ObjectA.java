package com.arao.challenges.topics.ciq;

public class ObjectA extends ObjectB implements Cloneable {

    int size;
    String name;

    public ObjectA(int size, String name) {
        this.size = size;
        this.name = name;
    }

    @Override
    public void method1(int x) {
        System.out.println("method 1 overrided");
    }



    @Override
    public Object clone() {
        ObjectA user = null;
        try {
            return  (ObjectA) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("test");
            return null;
        }
    }
}
