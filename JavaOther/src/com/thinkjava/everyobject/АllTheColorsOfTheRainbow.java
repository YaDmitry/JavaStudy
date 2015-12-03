package com.thinkjava.everyobject;

/**
 * Created by dyaprint on 03.12.2015.
 */

/*
Exercise 11: (1) Turn the AllTheColorsOfTheRainbow example into a program that
compiles and runs.
 */

public class АllTheColorsOfTheRainbow {

    int color;
    void changeColor(int newHue) {
        System.out.print(color);
        System.out.print(" changed to ");
        System.out.println(newHue);
    }

    public static void main(String[] args) {
        АllTheColorsOfTheRainbow Color = new АllTheColorsOfTheRainbow();
        Color.color = 3;
        Color.changeColor(5);
    }

}
