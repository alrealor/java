package com.arao.challenges.topics.ciq;

import java.util.Objects;

public class ObjectB {
    int a;
    String b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectB objectB = (ObjectB) o;
        return a == objectB.a && Objects.equals(b, objectB.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public void method1(int x) {
        System.out.println("method 1");
    }

    public static void method2(int x) {
        System.out.println("method 2");
    }


}
