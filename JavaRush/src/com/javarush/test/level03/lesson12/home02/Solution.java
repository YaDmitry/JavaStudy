package com.javarush.test.level03.lesson12.home02;

/* Я не хочу изучать Java, я хочу большую зарплату
Вывести на экран десять раз надпись «Я не хочу изучать Java, я хочу большую зарплату»
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        print5("Я не хочу изучать Java, я хочу большую зарплату");
        print5("Я не хочу изучать Java, я хочу большую зарплату");

    }

    public static void print5 (String s) {
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }
}
