package labs.lab7;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculator {

    public static double calculatePi(int nThreads, int nPoints) throws Exception {
        Thread[] threads = new Thread[nThreads];

        AtomicInteger pointsInRadius = new AtomicInteger(0);
        int n = nPoints / nThreads;

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                int result = 0;

                for (int j = 0; j < n; j++) {
                    double x = random.nextDouble();
                    double y = random.nextDouble();
                    if (Math.sqrt(x * x + y * y) <= 1.0) {
                        result++;
                    }
                }

                pointsInRadius.getAndAdd(result);
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int value = pointsInRadius.get();

        return (double) value / nPoints * 4;
    }
}
