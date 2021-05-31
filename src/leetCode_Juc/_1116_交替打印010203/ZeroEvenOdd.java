package leetCode_Juc._1116_交替打印010203;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    private Semaphore one = new Semaphore(1);
    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);
    public boolean flag = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            one.acquire();
            printNumber.accept(0);
            //System.out.print("0");
            if(i % 2 == 1) two.release();
            else three.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i+=2) {//步长为2，避免了奇数偶数的二次判断
            two.acquire();//偶数打印消耗资源
            printNumber.accept(i);
            one.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i+=2) {//步长为2，避免了奇数偶数的二次判断
            three.acquire();//偶数打印消耗资源
            printNumber.accept(i);
            one.release();
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero((a) -> System.out.print(a));
            } catch (InterruptedException e) {
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
            }
        }).start();
    }

}