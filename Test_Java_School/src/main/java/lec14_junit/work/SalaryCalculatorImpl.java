package lec14_junit.work;

import com.sun.corba.se.spi.legacy.interceptor.UnknownType;
import com.sun.deploy.net.socket.UnixSocketException;
import com.sun.org.apache.bcel.internal.classfile.Unknown;
import com.sun.tracing.dtrace.ProviderAttributes;

/**
 * Created by dmya on 3/17/2016.
 */
public class SalaryCalculatorImpl implements SalaryCalculator {

    public static final double BASIC_SALARY = 100D;

    @Override
    public double calculateSalary(double coef) {
        return BASIC_SALARY * coef;
    }

    public double getSalaryCoefficient(int averageMark) throws Exception{
        double salaryCoefficient;
        switch (averageMark) {
            case 3:
                salaryCoefficient = 1;
                break;
            case 4:
                salaryCoefficient = 1.3;
                break;
            case 5:
                salaryCoefficient = 1.5;
                break;
            default:
                throw new Exception();
        }
        return salaryCoefficient;
    }
}
