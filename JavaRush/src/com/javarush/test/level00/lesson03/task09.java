package com.javarush.test.level00.lesson03;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class task09
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String ch1 = reader.readLine();
        String ch2 = reader.readLine();

        int ich1 = Integer.parseInt(ch1);
        int ich2 = Integer.parseInt(ch2);

        System.out.println(name + " получает " + ich1 + " через " + ich2 + " лет.");


    }
}
