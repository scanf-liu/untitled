package leetCode_Juc._1195_交替打印字符串.api;

import java.util.function.IntConsumer;

public interface FizzBuzz {
    public void fizz(Runnable printFizz) throws InterruptedException;
    public void buzz(Runnable printBuzz) throws InterruptedException;
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException;
    public void number(IntConsumer printNumber) throws InterruptedException;
}
