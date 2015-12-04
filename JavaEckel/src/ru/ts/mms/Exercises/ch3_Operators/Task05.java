package ru.ts.mms.Exercises.ch3_Operators;

/**
 * Created by dyaprint on 04.12.2015.
 */

import static net.mindview.util.Print.*;

/****************** Exercise 5 *****************
 * Create a class called Dog with two Strings:
 * name and says. In main(), create two dogs,
 * "spot" who says, "Ruff!", and "scruffy" who
 * says, "Wurf!". Then display their names and
 * what they say.
 ***********************************************/

public class Task05 {

    static class Dog {
        String name;
        String says;
    }

    public static void main(String[] args) {

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.name = "spot";
        dog1.says = "Ruff!";
        dog2.name = "scruffy";
        dog2.says = "Wurf!";

        print(dog1.name + " says " + dog1.says);
        print(dog2.name + " says " + dog2.says);

    }
}
