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
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) Math.round((Math.random() * 10) + 1);
            System.out.println(randomArray[i]);
        }
    }
}