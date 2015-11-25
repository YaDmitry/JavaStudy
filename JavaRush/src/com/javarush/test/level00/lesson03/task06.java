package com.javarush.test.level00.lesson03;

/* Минимум трех чисел
Написать функцию, которая вычисляет минимум из трёх чисел.
Подсказка:
Нужно написать тело существующей функции min и исправить возвращаемое значение.
*/
public class task06
{
    public static int min(int a, int b, int c)
    {
        //напишите тут ваш код
        int m2;
        if (a < b)
            m2 = a;
        else
            m2 = b;
        if (m2 > c)
            m2 = c;

        return m2;
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println( min(1,2,3) );
        System.out.println( min(-1,-2,-3) );
        System.out.println( min(3,5,3) );
        System.out.println( min(10,5,10) );
    }

}
