package ru.ts.mms.Exercises.ch2_Objects;

import java.util.List;

/**
 * Created by dyaprint on 02.12.2015.
 */

/*
Exercise 9: (2) Write a program that demonstrates that autoboxing works for all the
primitive types and their wrappers.
*/

public class task09_ToAsk {

    static boolean Boo = false;
    static char A = 'a';
    static byte B = 3;
    static short S = 100;
    static int a = 30;
    static long k = 20;
    static float s = 3.123f;
    static Float ss = 3.1f;
    static double d = 3.1;
    static Double D = 3.1;

    List<Double> doubles;

    public static void main(String[] args) {
        System.out.println(ss + s);

        d = (double) D;
    }
}
