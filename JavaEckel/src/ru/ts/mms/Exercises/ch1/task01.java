package ru.ts.mms.Exercises.ch1;

/**
 * Created by dyaprint on 02.12.2015.
 */

/*
Exercise 1: (2) Create a class containing an int and a char that are not initialized, and
print their values to verify that Java performs default initialization.
 */

public class task01 {
    static int a;
    static char b;

    public static void main(String[] args) {
        System.out.println("a is " + a);
        System.out.println("b is '" + b + "'");
    }

}
