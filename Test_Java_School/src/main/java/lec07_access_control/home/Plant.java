package lec07_access_control.home;

/**
 * Created by Dmitry on 24/02/16.
 */
public class Plant extends Entity {

    Plant() {
        super(false);
    }

    @Override
    void eatMeal() {
        System.out.println("Я кушаю воду.");
    }
}
