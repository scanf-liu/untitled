package leetCode_other._190_颠倒二进制位;

public class test {
    public static void main(String[] args) {
        int i = 43261596;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(new Solution().reverseBits(i)));
    }
}
