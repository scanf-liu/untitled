package leetCode_Juc._1114_按序打印;

public class Foo {
    private volatile int flag = 1;
    private final Object obj = new Object();

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (obj) {
            while (flag != 1){
                obj.wait();
            }
            printFirst.run();
            flag = 2;
            obj.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (obj) {
            while (flag != 2){
                obj.wait();
            }
            printSecond.run();
            flag = 3;
            obj.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (obj) {
            while (flag != 3){
                obj.wait();
            }
            printThird.run();
            obj.notifyAll();
        }
    }
}


class Main{
    public static void main(String[] args) throws Exception{
        Foo foo = new Foo();
        Runnable first = new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        };
        Runnable third = new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        };
        Runnable second = new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        };
        foo.first(first);
        foo.second(second);
        foo.third(third);
    }
}

