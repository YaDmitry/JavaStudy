package robot;

import calculator.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Dmitry on 16/01/16.
 */

public class RobotTesting {
    Calculator parent; //ссылка на окно калькулятора

    RobotTesting(Calculator parent) {
        this.parent = parent;
    }


    public static void main(String[] args) {

        Calculator calc = new Calculator();

        //Addition Test
        try {
            click(calc.getNumButtons()[3], 500, 500);
            click(calc.getNumButtons()[4], 500, 500);
            click(calc.getButtonPlus(), 500, 500);
            click(calc.getNumButtons()[7], 500, 500);
            click(calc.getButtonEqual(), 500, 500);
            getResult(calc.getDisplayField().getText(), "42.0", "Addition");
        } catch (AWTException e) {
        }

        //ClearField test
        try {
            click(calc.getButtonAC(), 500, 500);
            getResult(calc.getDisplayField().getText(), "", "ClearField");
        } catch (AWTException e) {
        }

        //Subtraction Test
        try {
            click(calc.getNumButtons()[4], 500, 500);
            click(calc.getNumButtons()[4], 500, 500);
            click(calc.getButtonPoint(), 500, 500);
            click(calc.getNumButtons()[5], 500, 500);
            click(calc.getButtonMinus(), 500, 500);
            click(calc.getNumButtons()[9], 500, 500);
            click(calc.getNumButtons()[5], 500, 500);
            click(calc.getButtonEqual(), 500, 500);
            getResult(calc.getDisplayField().getText(), "-50.5", "Subtraction");
        } catch (AWTException e) {
        }







    }


    public static void click(JButton button, int millisPress, int millisAfter) throws AWTException {
        Point p = button.getLocationOnScreen();
        Robot r = new Robot();
        r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
        r.mousePress(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(millisPress);
        } catch (Exception e) {
        }
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(millisAfter);
        } catch (Exception e) {
        }
    }

    public static void getResult(String actual, String expected, String operation) {
        if (actual.equals(expected))
            System.out.println(operation + " test has PASSED");
        else System.out.println(operation + " test has FAILED");
    }

}