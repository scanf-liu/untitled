package leetCode._152_最大乘积子值;

/*给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

动态规划中，如果只与上一个有关，可以循环使用空间
正一遍反一遍

*/


public class test {
    public static void main(String[] args) {
        int[] a = new int[]{0};
        System.out.println(Solution.maxProduct(a));
        System.out.println(Solution.maxProduct_1(a));

    }
}

class Solution {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static int maxProduct_1(int[] nums) {
        int a = 1;
        int max = nums[0];

        for (int num : nums) {
            a = a * num;
            if (max < a) max = a;
            if (num == 0) a = 1;

        }
        a = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            a = a * nums[i];
            if (max < a) max = a;
            if (nums[i] == 0) a = 1;
        }
        return max;
    }
}