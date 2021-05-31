package leetCode_Juc._1117_合成H2O;

import java.util.concurrent.Semaphore;

public class H2O_1 {

    Semaphore hSmp = new Semaphore(2);
    Semaphore oSmp = new Semaphore(0);

    volatile int hNum = 0;

    public H2O_1() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSmp.acquire();
        releaseHydrogen.run();
        hNum++;
        if (hNum == 2) {
            oSmp.release(1);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSmp.acquire();
        releaseOxygen.run();
        hNum = 0;
        hSmp.release(2);
    }


    public static void main(String[] args) {
        String s = "OHOHOOHHOHHOOHHHHOOHOOHHOHHOOHHHOOHOHHOHHOHHHHHOHHHHHHHHHHHH";
        H2O_1 h2O = new H2O_1();
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
