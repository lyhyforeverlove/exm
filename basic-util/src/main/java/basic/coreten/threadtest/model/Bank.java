package basic.coreten.threadtest.model;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;
    private Object lock = new Object();

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    private Lock bankLock;

    private Condition sufficientFunds;

    static LongAdder adder = new LongAdder();
    static AtomicLong nextNumber = new AtomicLong();
    static Long num = 1L;

    public void transfer(int from, int to, double amount)throws InterruptedException{
        while (accounts[from] < amount) {
            return;
        }
        /*synchronized (lock){
            System.out.print(Thread.currentThread());
            accounts [from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts [to] += amount;
        }*/
        adder.increment();
        System.err.println("LongAdder: " + adder.sum());
        System.err.println("AtomicLong: " + nextNumber.incrementAndGet());
        System.err.println("Long : " + num++);
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());

    }

    private double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;

    }



    /*public synchronized void transfer(int from, int to, double amount)throws InterruptedException{
            while (accounts[from] < amount) {
                wait();
            }
            System.out.print(Thread.currentThread());
            accounts [from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts [to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            notifyAll();

    }

    private synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum += a;
        }
        return sum;

    }*/

    public int size(){
        return accounts.length;
    }



}
