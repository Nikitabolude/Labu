package labs.lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void transfer(Account from, Account to, int amount) {
        Account lock1 = from.getId() < to.getId() ? from : to;
        Account lock2 = from.getId() < to.getId() ? to : from;
        //noinspection SynchronizationOnLocalVariableOrMethodParameter
        synchronized (lock1) {
            //noinspection SynchronizationOnLocalVariableOrMethodParameter
            synchronized (lock2) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

    public Account randomAccount() {
        return accounts.get(ThreadLocalRandom.current().nextInt(accounts.size()));
    }

    public void createAccounts(int n) {
        for (int i = 0; i < n; i++) {
            Account ret = new Account(accounts.size() + 1, ThreadLocalRandom.current().nextInt(1_000, 10_000));
            accounts.add(ret);
        }
    }

    public long totalAmount() {
        long ret = 0;
        for (Account account : accounts) {
            ret += account.getValue();
        }
        return ret;
    }
}
