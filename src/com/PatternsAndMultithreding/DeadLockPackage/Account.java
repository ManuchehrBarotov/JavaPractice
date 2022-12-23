package com.PatternsAndMultithreding.DeadLockPackage;

public class Account {
    private int amount = 25000;

    public static void transfer(Account accountFirst, Account accountSecond, int amount) {
        accountFirst.withdraw(amount);
        accountSecond.deposit(amount);
    }


    public int deposit(int amount) {
        this.amount -= amount;
        return this.amount;
    }

    public void withdraw(int amount) {
        this.amount += amount;

    }

    public int getBalance() {
        return this.amount;
    }

}
