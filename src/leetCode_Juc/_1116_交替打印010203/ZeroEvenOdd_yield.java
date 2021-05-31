package leetCode_Juc._1116_交替打印010203;

import java.util.function.IntConsumer;

public class ZeroEvenOdd_yield {

    private int n;

    private volatile int state;

    public ZeroEvenOdd_yield(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state != 0) {
                Thread.yield();  //等待
            }
            printNumber.accept(0);
            if (i % 2 == 0) {
                state = 1;
            } else {
                state = 2;
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                Thread.yield();
            }
            printNumber.accept(i);
            state = 0;
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd_yield zeroEvenOdd_yield = new ZeroEvenOdd_yield(12);

        new Thread(()->{
            try {
                zeroEvenOdd_yield.odd(System.out::print);
            }catch (Exception execption){}
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd_yield.zero(System.out::print);
            }catch (Exception execption){}
        }).start();
        new Thread(()->{
            try {
                zeroEvenOdd_yield.even(System.out::print);
            }catch (Exception execption){}
        }).start();

    }
}