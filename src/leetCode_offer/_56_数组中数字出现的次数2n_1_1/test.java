package leetCode_offer._56_数组中数字出现的次数2n_1_1;
/*剑指 Offer 56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
示例 1：
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]*/

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(new Solution().singleNumbers(array)));
        System.out.println(Arrays.toString(new Solution1().singleNumbers(array)));
    }
}
