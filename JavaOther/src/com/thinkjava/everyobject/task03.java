package com.thinkjava.everyobject;

/**
 * Created by dyaprint on 02.12.2015.
 */

import java.io.*;

public class task03
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();

        System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");

    }
}