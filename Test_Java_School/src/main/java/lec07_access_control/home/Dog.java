package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */
public class Dog extends Animal {

    String name;

    public Dog(String myName) {
        super();
        this.name = myName;
    }

    public void startLive(){
        super.startLive();
    }

    public void getName() {
        System.out.println("Меня зовут " + this.name);
    }
}