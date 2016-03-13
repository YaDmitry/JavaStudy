package lec07_access_control.home;

/**
 * Created by Dmitry on 13/03/16.
 */

public class MainPlant {

    public static void main(String[] args) {

        Plant plant = new Plant();
        plant.startLive();
//        plant.getName(); - can't do that
//        plant.makeNoise(); - can't do that
        plant.eatMeal();
        plant.endLive();
    }
}
