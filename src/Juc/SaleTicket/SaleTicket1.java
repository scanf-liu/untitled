package Juc.SaleTicket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket1{
    private int num  = 90;
    private Lock lock = new ReentrantLock();
    public void saleTicket(){
        lock.lock();
        try {
            if(num > 0) System.out.println(Thread.currentThread().getName()+" now："+num--+" last "+num);
        }finally {
            lock.unlock();
        }
    }
}

public class SaleTicket1 {
    public static void main(String[] args) {
        Ticket a = new Ticket();
        new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    a.saleTicket();
                }
            }
        }),"A").start();
        new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    a.saleTicket();
                }
            }
        }),"B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                a.saleTicket();
            }
        },"C").start();
    }
}
