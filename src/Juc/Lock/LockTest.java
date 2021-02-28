package Juc.Lock;

import java.util.concurrent.TimeUnit;

class Phone {
    public synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("----sendEmail-----");
    }

    public synchronized void sendMES() throws Exception {
        System.out.println("----sendMES-----");
    }
}

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        Thread.sleep(200);
        new Thread(() -> {
            try {
                phone.sendMES();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
