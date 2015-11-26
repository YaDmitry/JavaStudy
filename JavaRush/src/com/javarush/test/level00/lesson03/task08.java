package com.javarush.test.level00.lesson03;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

import java.io.*;

public class task08
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sAge = reader.readLine();
        int nAge = Integer.parseInt(sAge);
        String name = reader.readLine();

        System.out.println(name + " захватит мир через " + nAge + " лет. Му-ха-ха!");

    }
}
