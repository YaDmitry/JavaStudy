package ru.ts.mms.Exercises.ch3_Operators;

/**
 * Created by dyaprint on 04.12.2015.
 */

/****************** Exercise 10 *****************
 * Write a program with two constant values, one
 * with alternating binary ones and zeroes, with
 * a zero in the least-significant digit, and the
 * second, also alternating, with a one in the
 * least-significant digit. (Hint: It's easiest to
 * use hexadecimal constants for this.) Combine
 * these two values every way possible using the
 * bitwise operators. Display the results using
 * Integer.toBinaryString().
 ************************************************/

public class Task10 {

    public static void main(String[] args) {

        int i1 = 0xbbbbbb;
        int i2 = 0x999977;
        System.out.println("~i1 = " + Integer.toBinaryString(~i1));
        System.out.println("~i2 = " + Integer.toBinaryString(~i2));
        System.out.println("i1 & i1 = " + Integer.toBinaryString(i1 & i1));
        System.out.println("i1 | i1 = " + Integer.toBinaryString(i1 | i1));
        System.out.println("i1 ^ i1 = " + Integer.toBinaryString(i1 ^ i1));
        System.out.println("i1 & i2 = " + Integer.toBinaryString(i1 & i2));
        System.out.println("i1 | i2 = " + Integer.toBinaryString(i1 | i2));
        System.out.println("i1 ^ i2 = " + Integer.toBinaryString(i1 ^ i2));

    }

}
