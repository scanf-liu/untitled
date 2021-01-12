package Juc.SaleTicket;


class AirCondition{
    private int tem = 0;

    public synchronized void incre() throws InterruptedException {
        if(tem != 0){
            this.wait();
        }
        tem++;
        System.out.println(Thread.currentThread().getName()+"\t"+tem);
        this.notifyAll();
    }

    public synchronized void decre() throws InterruptedException {
        if(tem == 0){
            this.wait();
        }
        tem--;
        System.out.println(Thread.currentThread().getName()+"\t"+tem);
        this.notifyAll();
    }
}

public class ThreadWaitNotify {
    public static void main(String[] args) {
        AirCondition air = new AirCondition();
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
        }, "B").start();
    }
}
