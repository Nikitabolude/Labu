package labs.lab1;

public class PrimeNumberUtils {

    public static int findPalindromicPrimes(int n) {
        int ret = 0;
        for (int x = 2; x < n; x++) {
            if (isPrime(x) && isPrime(reverse(x))) {
                ret++;
            }
        }
        return ret;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int reverse(int n) {
        int ret = 0;
        while (n != 0) {
            int d = n % 10;
            ret = ret * 10 + d;
            n /= 10;
        }
        return ret;
    }
}
