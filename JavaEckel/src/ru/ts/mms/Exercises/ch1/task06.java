package ru.ts.mms.Exercises.ch1;

/**
 * Created by dyaprint on 02.12.2015.
 */

/*Exercise 6: (2) Write a program that includes and calls the storage( ) method defined
        as a code fragment in this chapter.*/

public class task06 {

    static int storage(String s) {
        return s.length() * 2;
    }

    public static void main(String[] args) {

        System.out.println(storage("kjsldkfjskljd"));

    }

}