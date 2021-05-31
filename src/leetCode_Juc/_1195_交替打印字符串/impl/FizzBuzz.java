package leetCode_Juc._1195_交替打印字符串.impl;

import java.util.function.IntConsumer;

public class FizzBuzz implements leetCode_Juc._1195_交替打印字符串.api.FizzBuzz {
    private int n;
    private int t = 1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(t <= n){
            while(t<=n && (t%5 == 0 || t%3 != 0)){
                Thread.yield();
            }
            if(t > n) break;
            printFizz.run();
            t++;
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(t <= n){
            while((t%5 != 0 || t%3 == 0) && t <= n ){
                Thread.yield();
            }
            if(t > n) break;
            printBuzz.run();
            t++;
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(t <= n){
            while((t%5 != 0 || t%3 != 0)&& t <= n ){
                Thread.yield();
            }
            if(t > n) break;
            printFizzBuzz.run();
            t++;
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(t <= n){
            while((t%5 == 0 || t%3 == 0)&& t <= n){
                Thread.yield();
            }
            if(t > n) break;
            printNumber.accept(t);
            t++;
        }
    }
}