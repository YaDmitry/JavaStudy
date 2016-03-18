package lec14_junit.work;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by dmya on 3/17/2016.
 */
public class SalaryCalculatorImplTest {

    SalaryCalculatorImpl calculator = new SalaryCalculatorImpl();

    @Test
    public void testCalculateSalary() {

        SalaryCalculatorImpl scolarshipCalculator = new SalaryCalculatorImpl();
        double basicSalary = SalaryCalculatorImpl.BASIC_SALARY;
        double coef = 1.1D;
        double expected = basicSalary * coef;
        double actual = scolarshipCalculator.calculateSalary(coef);
        Assert.assertNotSame(expected, actual);//assertEquals(expected, actual, 0.00);
        Assert.assertFalse(actual > expected);
    }

    @Ignore
    @Test(timeout = 50, expected = Exception.class)
    public void testGetSalaryCoefficient() throws Exception{
        for (int i = 1; i < 100000; i++) {
            double stepUpCoefficient = 1 / i;
            double expected = 100 * stepUpCoefficient;
            double actual = calculator.calculateSalary(stepUpCoefficient);
            Assert.assertEquals(expected, actual, 0.01);
        }


    }
}