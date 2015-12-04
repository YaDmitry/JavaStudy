package ru.ts.mms.Exercises.ch3_Operators;

/**
 * Created by dyaprint on 04.12.2015.
 */

/****************** Exercise 7 *****************
 * Write a program that simulates coin-flipping.
 ***********************************************/

public class Task07 {

    static class Random {
        String a = "true";
        String b = "false";
    }

    public static void main(String[] args) {
        double result = Math.random();// [0:1)
        if(result <= .5) {
            System.out.println("Reshka");
        } else {
            System.out.println("Orel");
        }

    }

}
