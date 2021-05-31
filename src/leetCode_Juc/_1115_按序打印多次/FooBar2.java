package leetCode_Juc._1115_按序打印多次;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.Semaphore;
/*我们提供一个类：

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。

请设计修改程序，以确保 "foobar" 被输出 n 次。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/print-foobar-alternately
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class FooBar2 {
    private int n;
    private Semaphore one = new Semaphore(1);
    private Semaphore two = new Semaphore(0);


    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            one.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            two.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            two.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            one.release();
        }
    }
}

class Main1{
    public static void main(String[] args) {

        ArrayList<HashSet<Object>> arrayList = new ArrayList<>();

        FooBar2 fooBar = new FooBar2(12);
        new Thread(()->{
            try {
                fooBar.bar(()-> System.out.print("bar"));
            } catch (InterruptedException e) { }
        }).start();
        new Thread(()->{
            try {
                fooBar.foo(()-> System.out.print("foo"));
            } catch (InterruptedException e) { }
        }).start();
    }
}