package com.tsystems.library.libclient;

/**
 * Created by dyaprint on 13.04.2016.
 */
public class Logging {

    public static String makeItRed(String red) {
        red = "\033[31m" + red + "\033[0m";
        return red;
    }

    public static String makeItGreen(String green) {
        green = "\033[32m" + green + "\033[0m";
        return green;
    }

    public static String makeItYellow(String yellow) {
        yellow = "\033[33m" + yellow + "\033[0m";
        return yellow;
    }
}


