package leetCode_Juc._1116_交替打印010203;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd_lock {
    private int n;

    public ZeroEvenOdd_lock(int n) {
        this.n = n;
    }

    Lock lock = new ReentrantLock();
    Condition z = lock.newCondition();
    Condition num = lock.newCondition();
    volatile boolean zTurn = true;
    volatile int zIndex = 0;

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(;zIndex<n;) {
            lock.lock();
            try {
                while(!zTurn) {
                    z.await();
                }
                printNumber.accept(0);
                zTurn = false;
                num.signalAll();
                zIndex++;
            }finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2) {
            lock.lock();
            try {
                while(zTurn || (zIndex&1)==1) {
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2) {
            lock.lock();
            try {
                while(zTurn || (zIndex&1)==0) {
                    num.await();
                }
                printNumber.accept(i);
                zTurn = true;
                z.signal();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd_lock zeroEvenOdd_lock = new ZeroEvenOdd_lock(12);

        new Thread(()->{
            try {
                zeroEvenOdd_lock.odd(System.out::print);
            }catch (Exception execption){}
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd_lock.zero(System.out::print);
            }catch (Exception execption){}
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd_lock.even(System.out::print);
            }catch (Exception execption){}
        }).start();
    }
}