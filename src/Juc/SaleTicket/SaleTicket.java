package Juc.SaleTicket;

class Ticket {
    private int num = 90;

    synchronized void saleTicket() {
        if (num > 0) System.out.println(Thread.currentThread().getName() + " now：" + num-- + " last " + num);
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket a = new Ticket();
        new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    a.saleTicket();
                }
            }
        }), "A").start();
        new Thread((new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    a.saleTicket();
                }
            }
        }), "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                a.saleTicket();
            }
        }, "C").start();

    }

}
