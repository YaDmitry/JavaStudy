package lec07_access_control.home;

/**
 * Created by dmya on 3/10/2016.
 */

// TODO: 3/10/2016 посмотреть примитивы, использование методов наследуюмых у других классов

public class MainEntity {

    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.nameIs("Владимир");
        dog.startLive();
        System.out.println("Живой ли я = " + dog.getValueIsAlive());
    }
}