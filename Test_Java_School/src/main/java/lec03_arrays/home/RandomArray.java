package lec03_arrays.home;

/**
 * Created by Dmitry on 10/03/16.
 * <p>
 * Создайте массив из 8 случайных целых чисел из отрезка [1;10].
 * Выведите массив на экран в строку.
 * Замените каждый элемент с нечётным индексом на ноль.
 * Снова выведете массив на экран на отдельной строке.
 */


public class RandomArray {

    public static void main(String[] args) {

        int randomArray[] = new int[8];
        for (int i = 1; i < 10; i++)
            randomArray[i] = (int) (Math.random() * 8);

        for (int j = 1; j < randomArray.length; j++)
            System.out.println(randomArray[j]);
    }
}
