package leetCode_offer._29_顺时针打印数组;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 3, 5}, {4, 6, 8}, {2, 6, 78}};
        System.out.println(Arrays.toString(new Solution().spiralOrder(a)));
        System.out.println(Arrays.toString(new Solution1().spiralOrder(a)));
    }
}
