package leetCode_Juc._1226_哲学家进餐;

public interface DiningPhilosophersApi {
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException;
}
