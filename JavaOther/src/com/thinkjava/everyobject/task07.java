package com.thinkjava.everyobject;

public class task07 {

    static class StaticTest {
        static int i = 0;
    }

    static class Incrementable {
        static void increment() { StaticTest.i++; }
    }

    public static void main(String[] args) {
        Incrementable sf = new Incrementable();
        sf.increment();

        Incrementable.increment();
    }

}