package ru.ts.mms.Exercises.ch3_Operators;

/**
 * Created by dyaprint on 04.12.2015.
 */

/****************** Exercise 8 *****************
 * Show that hex and octal notations work with long
 * values. Use Long.toBinaryString() to display
 * the results.
 ***********************************************/

public class Task08 {

    public static void main(String[] args) {
        int i1 = 0x2f;
        int i2 = 0177;
        System.out.println(Long.toBinaryString(i1));
        System.out.println(Long.toBinaryString(i2));

    }

}