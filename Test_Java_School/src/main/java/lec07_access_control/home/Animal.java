package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */
public class Animal extends Entity implements MakeNoise {

    Animal() {
        super(true);
    }

    @Override
    protected void startLive() {
        super.startLive();
    }

    @Override
    void eatMeal() {
        System.out.println("Я ем мясо");
    }

    @Override
    public void makeNoise() {
        System.out.println("Я издаю звуки");
    }
}