package TIJ4.code.ch1.objects.Exercises;

/**
 * Created by dyaprint on 02.12.2015.
 */

/*
Exercise 4: (1) Turn the DataOnly code fragments into a program that compiles and
runs
Exercise 5: (1) Modify the previous exercise so that the values of the data in DataOnly
are assigned to and printed in main( ).
 */

public class task04 {

    public static class DataOnly {
        int a;
        double b;
        String c;
    }

    public static void main(String[] args) {
        DataOnly data = new DataOnly();
        data.a = 4;
        data.b = 6;
        data.c = "Russia ";

        System.out.println(data.c + data.a + data.b);

    }

}
