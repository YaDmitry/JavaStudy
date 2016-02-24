package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */

abstract class Entity {

    final boolean isAnimal = true;

    protected void startLive() {
        System.out.println("Начать Жить!");
    }

    protected void endLive() {
        System.out.println("Закончить Жить!");
    }

    abstract void eatMeal();
}
