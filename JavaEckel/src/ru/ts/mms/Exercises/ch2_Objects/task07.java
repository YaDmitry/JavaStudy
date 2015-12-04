package ru.ts.mms.Exercises.ch2_Objects;

public class task07 {

    static int i = 47;

    static void increment() {
        task07.i++;
    }

    public static void main(String[] args) {

        task07.increment();
        System.out.println(i);
    }

}