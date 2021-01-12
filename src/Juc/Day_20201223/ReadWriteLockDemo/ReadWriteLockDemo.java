package Juc.Day_20201223.ReadWriteLockDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key, Object value) throws InterruptedException {
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"\t write");
        TimeUnit.SECONDS.sleep(1);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+"\t write finish");
        readWriteLock.writeLock().unlock();
    }

    public void get(String key) throws InterruptedException {
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"\t get");
        TimeUnit.SECONDS.sleep(1);
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t get finish "+result);
        readWriteLock.readLock().unlock();
    }
}


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 6; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    myCache.put(tempInt+"",tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 6; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    myCache.get(tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
