package Juc.Day_20201230;

import java.util.concurrent.CompletableFuture;

public class CompletavleFutureDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName() + "\t没有返回， 更新完成"));
        completableFuture.get();

        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t有返回 ");
            int a = 10 / 0;
            return 1024;
        }).whenComplete((u, e) -> {
            System.out.println("answer is \t" + u);
            System.out.println("exception is \t" + e);
        }).exceptionally(f -> {
            System.out.println(f.getMessage());
            return 4444;
        });

        completableFuture1.get();

    }
}
