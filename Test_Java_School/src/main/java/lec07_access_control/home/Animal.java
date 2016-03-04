package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */
public class Animal extends Entity {


    Animal(boolean isAnimal) {
        super(isAnimal);
    }

    @Override
    protected void startLive() {
        super.startLive();
    }

    @Override
    void eatMeal() {
    }

    public static void main(String[] args) {
//        new startLive
    }
}