package unit_testing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by dmya on 1/21/2016.
 */
public class CalculatorTestingTest {

    @Test (timeout = 1000)
    public void testAdd() throws Exception {
        int tree = CalculatorTesting.add(4, 5);
        assertEquals(9, tree, 0);
        assertNull(tree);

    }
}