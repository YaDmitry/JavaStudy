package com.thinkjava.everyobject;

/**
 * Created by dyaprint on 02.12.2015.
 */

/*Exercise 7: (1) Turn the Incrementable code fragments into a working program.*/

public class task07 {


    static int i = 47;

    task07 st1 = new task07();

    static class Incrementable {
        void increment() { task07.i++; }
    }

    public static void main(String[] args) {
        task07.i;
    }

}
