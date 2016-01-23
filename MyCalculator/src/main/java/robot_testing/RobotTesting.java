package robot_testing;

import javax.swing.JButton;
import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * Created by Dmitry on 16/01/16.
 */

public class RobotTesting {

    //Method to getLocationOnScreen and click on button
    public static void click(JButton button) throws AWTException {
        Point p = button.getLocationOnScreen();
        Robot r = new Robot();
        r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
        r.mousePress(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(300);
        } catch (Exception e) {
        }
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(300);
        } catch (Exception e) {
        }
    }

//    public static void getResultClicked(String actual, String expected, String operation) {
//        if (actual.equals(expected))
//            System.out.println("\033[32m" + operation + " test is PASSED" + "\033[0m");
//        else {
//            System.out.print("\033[31m" + operation + " test is FAILED: " + "\033[0m");
//            System.out.println("Actual = " + actual + ", Expected = " + expected);
//        }
//    }
}