package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */
public class Dog extends Animal {

    String name;

    Dog(String myName) {
        super();
        this.name = myName;
    }

    public void getName() {
        System.out.println("Меня зовут " + this.name);
    }
}