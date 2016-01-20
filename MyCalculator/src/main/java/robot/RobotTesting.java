package robot;
import calculator.Calculator;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Dmitry on 16/01/16.
 */

public class RobotTesting {
    private static Robot robot = null;

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }


    }
//doClick
//
//        click(150, 250);
//    }
//
    public static void smokeTest() {
//        robot.;
        robot.delay(5);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);
    }
}