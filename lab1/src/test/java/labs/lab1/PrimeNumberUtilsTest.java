package labs.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeNumberUtilsTest {

    @Test
    void testFindPrimeNumberWithMaximumBitCount() {
        assertEquals(4, PrimeNumberUtils.findPalindromicPrimes(10));
        assertEquals(13, PrimeNumberUtils.findPalindromicPrimes(100));
        assertEquals(56, PrimeNumberUtils.findPalindromicPrimes(1000));
    }
}
