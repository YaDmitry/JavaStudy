package lec04_classes.home;

/**
 * Created by Dmitry on 12/03/16.
 */
public class DogClass {

    String name; // имя
    int age;     // возраст
    String breed;// порода
    String owner;

    // метод задания имени
    public void setName(String setName) {
        name = setName;
    }

    // метод получения имени
    public String getName() {
        return name;
    }

    // метод лаять
    public void bark() {
        System.out.println("Amma barking");
    }
}
