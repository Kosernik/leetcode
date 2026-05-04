package Quests.Math;

import java.util.Arrays;

public class Bank {
    private final long[] balance;

    public Bank(long[] balance) {
        this.balance = Arrays.copyOf(balance, balance.length);
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isAccountInvalid(account1) || isAccountInvalid(account2)) return false;

        if (balance[account1 - 1] < money) return false;

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;

        return true;
    }

    public boolean deposit(int account, long money) {
        if (isAccountInvalid(account)) return false;

        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (isAccountInvalid(account)) return false;
        if (balance[account - 1] < money) return false;

        balance[account - 1] -= money;
        return true;
    }

    private boolean isAccountInvalid(int account) {
        if (account <= 0) return true;
        if (account > balance.length) return true;
        return false;
    }
}
