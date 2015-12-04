package ru.ts.mms.Exercises.ch3_Operators;

/**
 * Created by dyaprint on 04.12.2015.
 */

/****************** Exercise 6 *****************
 * Following Exercise 5 assign, a new Dog
 * reference to spot's object. Test for comparison
 * using == and equals() for all references.
 ***********************************************/

public class Task06 {
    public static void main(String[] args) {
        Task05.Dog dog1 = new Task05.Dog();
        Task05.Dog dog2 = new Task05.Dog();
        Task05.Dog dog3 = new Task05.Dog();

        /*TODO fill the dogs*/

        compare(dog1, dog2);
        compare(dog2, dog3);
        compare(dog1, dog3);
    }

    private static void compare(Task05.Dog dog1, Task05.Dog dog2) {
        //TODO compare with == and equals()
        System.out.println(/*result*/);
    }
}
