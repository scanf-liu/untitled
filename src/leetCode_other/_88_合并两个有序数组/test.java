package leetCode_other._88_合并两个有序数组;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,0,0,0};
        new Solution().merge(a, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(a));
    }
}
