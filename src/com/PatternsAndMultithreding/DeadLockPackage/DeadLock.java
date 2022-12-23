package com.PatternsAndMultithreding.DeadLockPackage;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {


    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private Account accountFirst;
    private Account accountSecond;

    public DeadLock(Account accountFirst, Account accountSecond) {
        this.accountFirst = accountFirst;
        this.accountSecond = accountSecond;
    }

    public void firstThread() {

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            try {
                doLock(lock1, lock2);
                Account.transfer(accountFirst, accountSecond, random.nextInt(5000));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }


    public void secondThread() {

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            try {
                doLock(lock2, lock1);
                Account.transfer(accountSecond, accountFirst, random.nextInt(5000));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }

        }
    }

    public void finished() {
        System.out.println("Balance account 1 : " + accountFirst.getBalance());
        System.out.println("Balance account 2 : " + accountSecond.getBalance());
        System.out.println("Total balance is : " + (accountSecond.getBalance() + accountFirst.getBalance()));
    }


    private void doLock(Lock lock1, Lock lock2) {
        Lock lockOne = lock1;
        Lock lockSecond = lock2;

        boolean isLockFist = false;
        boolean isLockSecond = false;

        while (true) {
            try {
                isLockFist = lockOne.tryLock();
                isLockSecond = lockSecond.tryLock();
            } finally {
                if (isLockFist && isLockSecond) {
                    return;
                }

                if (isLockFist) {
                    lockOne.unlock();
                }

                if (isLockSecond) {
                    lockSecond.unlock();
                }
            }
        }
    }
}
