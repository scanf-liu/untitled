package leetCode_Juc._1117_合成H2O;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {

    private Semaphore hSmp = new Semaphore(2);
    private Semaphore oSmp = new Semaphore(1);

    CyclicBarrier cb = new CyclicBarrier(3, () -> {
        hSmp.release(2);
        oSmp.release(1);
    });

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSmp.acquire();
        releaseHydrogen.run();
        try {
            cb.await();
        } catch (Exception e) {}
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSmp.acquire();
        releaseOxygen.run();
        try {
            cb.await();
        } catch (Exception e) {}
    }


    public static void main(String[] args) {
        String s = "OHOHOOHHOHHOOHHHHOOHOOHHOHHOOHHHOOHOHHOHHOHHHHHOHHHHHHHHHHHH";
        H2O h2O = new H2O();
        for(char i : s.toCharArray()){
            if(i == 'H'){
                new Thread(() -> {
                    try{
                        h2O.hydrogen(()-> System.out.print("H"));
                    }catch (Exception e){}
                }).start();
            }else{
                new Thread(() -> {
                    try{
                        h2O.oxygen(()-> System.out.print("O"));
                    }catch (Exception e){}
                }).start();
            }


        }



    }
}
