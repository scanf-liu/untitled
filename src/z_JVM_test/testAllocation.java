package z_JVM_test;




public class testAllocation {

    private static final int _1MB = 1024 * 1024;

    public static void testAll(){
        byte[] all1,all2,all3,all4;

        all1 = new byte[_1MB/4];
        all2 = new byte[4 * _1MB];
        all3 = new byte[4 * _1MB];
        all3 = null;
        all3 = new byte[4*_1MB];
    }

    public static void main(String[] args) {
        testAll();
    }


}
