package calculator;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

import static robot_testing.RobotTesting.click;

/**
 * Created by Dmitry on 21/01/16.
 */

public class CalculatorEngineTest {

    Calculator calc;

    @BeforeMethod
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    //Checks you can press all the Numeric buttons and Clear a text field after
    public void numericTest() {
        for (int i = 0; i < 10; i++) {
            try {
                click(calc.getNumButtons()[i]);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "0123456789");
        try {
            click(calc.getButtonAC());
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "");
    }


    @Test
    //Addition Test
    public void additionTest() {
        try {
            click(calc.getNumButtons()[3]);
            click(calc.getNumButtons()[4]);
            click(calc.getButtonPlus());
            click(calc.getNumButtons()[7]);
            click(calc.getButtonEqual());
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "41.0");
    }

    @Test
    //Subtraction Test [should FAIL]
    public void subtractionTest() {
        try {
            click(calc.getNumButtons()[4]);
            click(calc.getNumButtons()[4]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[5]);
            click(calc.getButtonMinus());
            click(calc.getNumButtons()[9]);
            click(calc.getNumButtons()[5]);
            click(calc.getButtonEqual());
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "-52.5");
    }

    @Test
    //Division Test
    public void divisionTest() {
        try {
            click(calc.getNumButtons()[4]);
            click(calc.getNumButtons()[4]);
            click(calc.getNumButtons()[6]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[8]);
            click(calc.getButtonDivide());
            click(calc.getNumButtons()[2]);
            click(calc.getButtonEqual());
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "223.4");
    }

    @Test
    //Checks whether you can Divide by ZERO
    public void divideZeroTest() {
        try {
            click(calc.getNumButtons()[4]);
            click(calc.getNumButtons()[6]);
            click(calc.getButtonPoint());
            click(calc.getNumButtons()[8]);
            click(calc.getButtonDivide());
            click(calc.getNumButtons()[0]);
            click(calc.getButtonEqual());
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "Can't do that!");
    }

    @Test
    //Multiplication Test
    public void multiplicationTest() {
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
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "673.92");
    }

    @Test
    //Double Value Test
    public void doubleValueTest() {
        try {
            click(calc.getNumButtons()[1]);
            click(calc.getNumButtons()[6]);
            click(calc.getButtonX2());
            click(calc.getButtonPlus());
            click(calc.getNumButtons()[1]);
            click(calc.getNumButtons()[4]);
            click(calc.getButtonEqual());
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(calc.getDisplayField().getText(), "270.0");
    }
}