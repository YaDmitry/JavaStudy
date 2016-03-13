package lec07_access_control.home;

/**
 * Created by dmya on 3/10/2016.
 */

public class MainAnimal {

    public static void main(String[] args) {

        Mops mops = new Mops("King");
        mops.startLive();
        mops.getName();
        mops.makeNoise();
        mops.eatMeal();
        mops.endLive();
    }
}