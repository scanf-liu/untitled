package leetCode_Juc._1115_按序打印多次;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    private int n1 = 0;
    private int n2 = 0;
    private Object o = new Object();
    private boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(o){
                while(!flag){
                    o.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = false;
                o.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(o){
                while(flag){
                    o.wait();
                }
                flag = true;
                printBar.run();
                o.notifyAll();
            }
        }
    }
}



class Main{
    public static void main(String[] args) throws Exception{
        FooBar fooBar = new FooBar(2);
        Runnable printFoo = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Runnable printBar = new Runnable() {
            @Override
            public void run() {
                System.out.print("bar");
            }
        };
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    fooBar.bar(printBar);
                }catch (Exception e){
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                try{
                    fooBar.foo(printFoo);
                }catch (Exception e){
                }
            }
        });
        thread1.start();
        thread2.start();



    }
}