package labs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PiCalculatorTest {

    @Test
    void testCalculatePi() throws Exception {
        double result = PiCalculator.calculatePi(8, 500_000_000);
        assertEquals(Math.PI, result, 0.01);
    }
}
