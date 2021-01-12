package Juc.SaleTicket;


class AirCondition1{
    private int tem = 0;

    public synchronized void incre() throws InterruptedException {
        while(tem != 0){
            this.wait();
        }
        tem++;
        System.out.println(Thread.currentThread().getName()+"\t"+tem);
        this.notifyAll();
    }

    public synchronized void decre() throws InterruptedException {
        while(tem == 0){
            this.wait();
        }
        tem--;
        System.out.println(Thread.currentThread().getName()+"\t"+tem);
        this.notifyAll();
    }
}

public class ThreadWaitNotify1 {
    public static void main(String[] args) {
        AirCondition1 air = new AirCondition1();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    air.decre();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    air.incre();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    air.incre();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    air.decre();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "D").start();
    }
}
