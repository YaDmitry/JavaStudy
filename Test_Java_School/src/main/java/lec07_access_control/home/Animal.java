package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */
public class Animal extends Entity {



    @Override
    void eatMeal() {
        System.out.println("Я кушаю мясные продукты.");
    }

    void amIAlive() {
        if (isAnimal == true) {
            System.out.println("Я существую в мире.");

        } else System.out.println("Я НЕ существую в мире.");
    }
}