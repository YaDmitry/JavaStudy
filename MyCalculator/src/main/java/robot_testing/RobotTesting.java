package robot_testing;

import calculator.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by Dmitry on 16/01/16.
 */

public class RobotTesting {

    //Smoke Test for Calculator

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        //Checks you can press all the Numeric buttons
        for (int i = 0; i < 10; i++) {
            try {
                click(calc.getNumButtons()[i]);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
        getResult(calc.getDisplayField().getText(), "0123456789", "Numeric");

        //ClearField test
        try {
            click(calc.getButtonAC());
            getResult(calc.getDisplayField().getText(), "", "ClearField");
        } catch (AWTException e) {
            e.printStackTrace();
        }

        //Addition Test
        try {
            click(calc.getNumButtons()[3]);
            click(calc.getNumButtons()[4]);
            click(calc.getButtonPlus());
            click(calc.getNumButtons()[7]);
            click(calc.getButtonEqual());
            getResult(calc.getDisplayField().getText(), "41.0", "Addition");
            click(calc.getButtonAC());
        } catch (AWTException e) {
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
        }

        //Checks whether you can Divide by ZERO
        try {
            click(calc.getNumButtons()[4]);
            click(calc.getNumButtons()[6]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[8]);
            click(calc.getButtonDivide());
            click(calc.getNumButtons()[0]);
            click(calc.getButtonEqual());
            getResult(calc.getDisplayField().getText(), "Can't do that!", "Divide by ZERO");
        } catch (AWTException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }

        //Double Value Test
        try {
            click(calc.getNumButtons()[1]);
            click(calc.getNumButtons()[6]);
            click(calc.getButtonX2());
            click(calc.getButtonPlus());
            click(calc.getNumButtons()[1]);
            click(calc.getNumButtons()[4]);
            click(calc.getButtonEqual());
            getResult(calc.getDisplayField().getText(), "270.0", "Double Value");
        } catch (AWTException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

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

    public static void getResult(String actual, String expected, String operation) {
        if (actual.equals(expected))
            System.out.println("\033[32m" + operation + " test is PASSED" + "\033[0m");
        else {
            System.out.print("\033[31m" + operation + " test is FAILED: " + "\033[0m");
            System.out.println("Actual = " + actual + ", Expected = " + expected);
        }
    }
}