package Juc.SaleTicket;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print1(){
        lock.lock();
        try {
            while(num != 1) condition1.await();
            System.out.println(Thread.currentThread().getName()+"\tprint1");
            num = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print2(){
        lock.lock();
        try {
            while(num != 2) condition2.await();
            System.out.println(Thread.currentThread().getName()+"\tprint2");
            num = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print3(){
        lock.lock();
        try {
            while(num != 3) condition3.await();
            System.out.println(Thread.currentThread().getName()+"\tprint3");
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource a = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                a.print1();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                a.print2();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                a.print3();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                a.print3();
            }
        }, "D").start();
    }
}
