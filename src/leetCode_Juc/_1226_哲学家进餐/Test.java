package leetCode_Juc._1226_哲学家进餐;

public class Test {
    static public void cal(DiningPhilosophersApi diningPhilosophers, int n){
            new Thread(()-> {
                try {
                    for (int j = 0; j < n; j++) {
                        diningPhilosophers.wantsToEat(0,
                                () -> System.out.println(0 + "->left ↑"),
                                () -> System.out.println(0 + "->right ↑"),
                                () -> System.out.println(0 + "->eat"),
                                () -> System.out.println(0 + "->left ↓"),
                                () -> System.out.println(0 + "->right ↓")
                        );
                    }
                } catch (Exception e) { }
            }).start();
        new Thread(()-> {
            try {
                for (int j = 0; j < n; j++) {
                    diningPhilosophers.wantsToEat(1,
                            () -> System.out.println(1 + "->left ↑"),
                            () -> System.out.println(1 + "->right ↑"),
                            () -> System.out.println(1 + "->eat"),
                            () -> System.out.println(1 + "->left ↓"),
                            () -> System.out.println(1 + "->right ↓")
                    );
                }
            } catch (Exception e) { }
        }).start();
        new Thread(()-> {
            try {
                for (int j = 0; j < n; j++) {
                    diningPhilosophers.wantsToEat(2,
                            () -> System.out.println(2 + "->left ↑"),
                            () -> System.out.println(2 + "->right ↑"),
                            () -> System.out.println(2 + "->eat"),
                            () -> System.out.println(2 + "->left ↓"),
                            () -> System.out.println(2 + "->right ↓")
                    );
                }
            } catch (Exception e) { }
        }).start();
        new Thread(()-> {
            try {
                for (int j = 0; j < n; j++) {
                    diningPhilosophers.wantsToEat(0,
                            () -> System.out.println(3 + "->left ↑"),
                            () -> System.out.println(3 + "->right ↑"),
                            () -> System.out.println(3 + "->eat"),
                            () -> System.out.println(3 + "->left ↓"),
                            () -> System.out.println(3 + "->right ↓")
                    );
                }
            } catch (Exception e) { }
        }).start();
        new Thread(()-> {
            try {
                for (int j = 0; j < n; j++) {
                    diningPhilosophers.wantsToEat(4,
                            () -> System.out.println(4 + "->left ↑"),
                            () -> System.out.println(4 + "->right ↑"),
                            () -> System.out.println(4 + "->eat"),
                            () -> System.out.println(4 + "->left ↓"),
                            () -> System.out.println(4 + "->right ↓")
                    );
                }
            } catch (Exception e) { }
        }).start();
    }

    public static void main(String[] args) throws Exception {
        Test.cal(new DiningPhilosophers(), 5);
        Thread.sleep(5000);
        System.out.println();
        Test.cal(new DiningPhilosophers1(), 5);
    }
}
