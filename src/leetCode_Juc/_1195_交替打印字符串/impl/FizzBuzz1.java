package leetCode_Juc._1195_交替打印字符串.impl;

import leetCode_Juc._1195_交替打印字符串.api.FizzBuzz;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz1 implements FizzBuzz {
    private int n;
    private Integer curr;
    private final Semaphore isFizz;
    private final Semaphore isBuzz;
    private final Semaphore isFizzBuzz;
    private final Semaphore other;

    public FizzBuzz1(int n) {
        this.n = n;
        this.curr = 1;
        this.isBuzz = new Semaphore(0);
        this.isFizz = new Semaphore(0);
        this.isFizzBuzz = new Semaphore(0);
        this.other = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            //System.out.println("isFizz wait" + curr);
            isFizz.acquire();
            if (curr > n) {
                break;
            }
            //System.out.println("isFizz run" + curr);
            printFizz.run();
            other.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            //System.out.println("isBuzz wait" + curr);
            isBuzz.acquire();
            if (curr > n) {
                break;
            }
            //System.out.println("isBuzz run" + curr);
            printBuzz.run();
            other.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            //System.out.println("isFizzBuzz wait" + curr);
            isFizzBuzz.acquire();
            if (curr > n) {
                break;
            }
            //System.out.println("isFizzBuzz run" + curr);
            printFizzBuzz.run();
            other.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (curr <= n) {
            //System.out.println("Number wait" + curr);
            if (curr % 3 == 0 && curr % 5 == 0) {
                //System.out.println("Number -> FizzBuzz" + curr);
                isFizzBuzz.release();
            } else if (curr % 3 == 0) {
                //System.out.println("Number -> Fizz" + curr);
                isFizz.release();
            } else if (curr % 5 == 0) {
                //System.out.println("Number -> Buzz" + curr);
                isBuzz.release();
            } else {
                //System.out.println("Number run" + curr);
                printNumber.accept(curr);
                other.release();
            }
            other.acquire();
            curr++;
        }
        isFizzBuzz.release();
        isFizz.release();
        isBuzz.release();
    }
}