package z_JVM_test;

public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();
        private static Integer MAX_COUNT = 100;
        private String name;

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); // 这里设一个断点
        }
    }

    private static class ObjectHolder {
        private String holderName;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }
}

