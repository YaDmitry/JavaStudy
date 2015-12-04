package ru.ts.mms.Exercises.ch3_Operators;

/**
 * Created by dyaprint on 04.12.2015.
 */

/******************
 * Exercise 2 *****************
 * Create a class containing a float and use it to
 * demonstrate aliasing.
 ***********************************************/

public class Task02 {
    float aFloat;

    public static void main(String[] args) {
        Task02 f1 = new Task02();
        Task02 f2 = new Task02();

        f1.aFloat = 3.5f;
        f2.aFloat = 5.1f;

        System.out.println(f1.aFloat);
        System.out.println(f2.aFloat);

        f1 = f2;
        f2.aFloat = 1f;

        System.out.println(f1.aFloat);
        System.out.println(f2.aFloat);

        System.out.println(f1);
        System.out.println(f2);
    }
}