package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 * <p>
 * В классе Entity создать 3 метода – начатьЖить, закончитьЖить, приниматьПищу, при этом метод принимать пищу должен быть абстрактным.
 * Создайте в Entity final-поле isAnimal, отвечающее за то, является ли данная сущность животным.
 * Все наследники Entity должны знать, существуют ли они в мире.
 * Только собаки должны иметь имя.
 * Только животные могут издавать звуки.
 * Класс Entity не должен быть виден нигде, кроме своего пакета.
 * Методы начатьЖить и  закончитьЖить класса Entity  не должны быть доступны никому, кроме наследников.
 *
 * [Entity|isAnimal:boolean;isAlive:boolean|#startLive():void;#endLive():void;eatMeal():void]^-[Animal|+makeNoise():void], [Animal]^-[Dog|name:String|+getName():void], [Dog]^-[Mops], [Entity]^-[Plant]
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
        System.out.println("isAlive = " + isAlive);
    }

    protected void endLive() {
        isAlive = false;
        System.out.println("Закончить Жить!");
        System.out.println("isAlive = " + isAlive);
    }

    abstract void eatMeal();
}