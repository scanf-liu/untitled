package leetCode_offer._66_构建乘积数组;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 5, 6, 54, 8};
        System.out.println(Arrays.toString(new Solution().constructArr(a)));
        System.out.println(Arrays.toString(new Solution1().constructArr(a)));
        System.out.println(Arrays.toString(new Solution2().constructArr(a)));
    }
}
