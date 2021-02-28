package Juc.SaleTicket;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition2 {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void de() {
        lock.lock();
        try {
            while (num == 0) condition.await();
            num--;
            System.out.println(Thread.currentThread().getName() + '\t' + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void in() {
        lock.lock();
        try {
            while (num != 0) condition.await();
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


public class ThreadWaitNotify2 {
    public static void main(String[] args) {
        AirCondition2 a = new AirCondition2();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.de();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.de();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.in();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.in();
            }
        }, "D").start();

    }
}
