package leetCode_Juc._1226_哲学家进餐;

public class DiningPhilosophers implements DiningPhilosophersApi {
    boolean[] fork = new boolean[5];
    public DiningPhilosophers() {

    }
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while(fork[philosopher] || fork[(philosopher+1)%5]){
            Thread.yield();
        }
        fork[philosopher] = true;
        fork[(philosopher+1)%5] = true;
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();
        fork[philosopher] = false;
        fork[(philosopher+1)%5] = false;
    }
}