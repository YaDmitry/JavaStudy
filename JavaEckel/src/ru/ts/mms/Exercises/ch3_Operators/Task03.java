package ru.ts.mms.Exercises.ch3_Operators;

/**
 * Created by dyaprint on 04.12.2015.
 */

/****************** Exercise 3 *****************
 * Create a class containing a float and use it
 * to demonstrate aliasing during method calls.
 ***********************************************/

public class Task03 {

   static class Float {
        float Number;
    }

   static void M(Float f) {
       f.Number = 3.1f;
   }

    public static void main(String[] args) {
    Float Aliasing = new Float();
        Aliasing.Number = 55f;
        System.out.println("Aliasing = " + Aliasing.Number);
        M(Aliasing);
        System.out.println("Aliasing = " + Aliasing.Number);
    }

}

//almost got it still don't understand why do i need this