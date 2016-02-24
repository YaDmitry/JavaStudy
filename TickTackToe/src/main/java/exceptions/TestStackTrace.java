package exceptions;

/**
 * Created by Dmitry on 25/01/16.
 */
public class TestStackTrace {

    TestStackTrace() {
        divideByZero();
    }

    int divideByZero() {
        return 25 / 0;
    }

    public static void main(String[] args) {
        new TestStackTrace();
    }
}
