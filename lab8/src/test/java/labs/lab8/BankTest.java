package labs.lab8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {

    @Test
    void testTransfer() throws InterruptedException {
        Bank bank = new Bank();
        bank.createAccounts(300);

        long amountBefore = bank.totalAmount();

        Thread[] threads = new Thread[3000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    bank.transfer(bank.randomAccount(), bank.randomAccount(), 100);
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long amountAfter = bank.totalAmount();

        assertEquals(amountBefore, amountAfter);
    }
}
