package com.tsystems.library.libclient;

/**
 * Created by dyaprint on 13.04.2016.
 */
public class Logging {

    public static String makeItGreen(String green) {
        green = "\033[32m" + green + "\033[0m";
        return green;
    }

    public static String makeItYellow(String yellow) {
        yellow = "\033[33m" + yellow + "\033[0m";
        return yellow;
    }

    public static void printUserAction(String userName, String bookTitle) {
        System.out.println("Читатель " + makeItGreen(userName) + " взял(а) книгу " + makeItYellow(bookTitle) + ".");
    }
}


