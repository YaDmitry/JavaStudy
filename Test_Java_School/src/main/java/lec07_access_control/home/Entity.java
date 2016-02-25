package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */

abstract class Entity {

    final boolean isAnimal;
    boolean isAlive;

    Entity(boolean isAnimal) {
        this.isAnimal = isAnimal;
    }

    protected void startLive() {
        isAlive = true;
        System.out.println("Начать Жить!");
    }

    protected void endLive() {
        isAlive = false;
        System.out.println("Закончить Жить!");
    }

    abstract void eatMeal();

}