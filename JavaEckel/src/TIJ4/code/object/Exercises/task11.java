package TIJ4.code.object.Exercises;

/**
 * Created by dyaprint on 03.12.2015.
 */

/*
Exercise 11: (1) Turn the AllTheColorsOfTheRainbow example into a program that
compiles and runs.
 */

public class task11 {

    int color;
    void changeColor(int newHue) {
        System.out.print(color);
        System.out.print(" changed to ");
        System.out.println(newHue);
    }

    public static void main(String[] args) {
        task11 Color = new task11();
        Color.color = 3;
        Color.changeColor(5);
    }
}
