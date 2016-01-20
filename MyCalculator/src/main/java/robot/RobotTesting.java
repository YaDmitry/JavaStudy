package robot;

import calculator.Calculator;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Dmitry on 16/01/16.
 */

public class RobotTesting {

    //Smoke Test for Calculator

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        //Addition Test
        try {
            click(calc.getNumButtons()[3]);
            click(calc.getNumButtons()[4]);
            click(calc.getButtonPlus());
            click(calc.getNumButtons()[7]);
            click(calc.getButtonEqual());
            getResult(calc.getDisplayField().getText(), "41.0", "Addition");
        } catch (AWTException e) {
        }

        //ClearField test
        try {
            click(calc.getButtonAC());
            getResult(calc.getDisplayField().getText(), "", "ClearField");
        } catch (AWTException e) {
        }

        //Subtraction Test
        try {
            click(calc.getNumButtons()[4]);
            click(calc.getNumButtons()[4]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[5]);
            click(calc.getButtonMinus());
            click(calc.getNumButtons()[9]);
            click(calc.getNumButtons()[5]);
            click(calc.getButtonEqual());
            getResult(calc.getDisplayField().getText(), "-52.5", "Subtraction");
            click(calc.getButtonAC());
        } catch (AWTException e) {
        }

        //Division Test
        try {
            click(calc.getNumButtons()[4]);
            click(calc.getNumButtons()[6]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[8]);
            click(calc.getButtonDivide());
            click(calc.getNumButtons()[2]);
            click(calc.getButtonEqual());
            getResult(calc.getDisplayField().getText(), "23.4", "Division");
            click(calc.getButtonAC());
        } catch (AWTException e) {
        }

        //Multiplication Test
        try {
            click(calc.getNumButtons()[3]);
            click(calc.getNumButtons()[2]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[4]);
            click(calc.getButtonMultiply());
            click(calc.getNumButtons()[2]);
            click(calc.getNumButtons()[0]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[8]);
            click(calc.getButtonEqual());
            getResult(calc.getDisplayField().getText(), "673.92", "Multiplication");
            click(calc.getButtonAC());
        } catch (AWTException e) {
        }

    }


    public static void click(JButton button) throws AWTException {
        Point p = button.getLocationOnScreen();
        Robot r = new Robot();
        r.mouseMove(p.x + button.getWidth() / 2, p.y + button.getHeight() / 2);
        r.mousePress(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }

    public static void getResult(String actual, String expected, String operation) {
        if (actual.equals(expected))
            System.out.println("\033[32m" + operation + " test has PASSED" + "\033[0m");
        else {
            System.out.print("\033[31m" + operation + " test has FAILED: " + "\033[0m");
            System.out.print("Actual = " + actual);
            System.out.println(", Expected = " + expected);
        }
    }
}