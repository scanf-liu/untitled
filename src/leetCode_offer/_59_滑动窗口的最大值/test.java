package leetCode_offer._59_滑动窗口的最大值;

import java.util.Arrays;

/*剑指 Offer 59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */


public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 5, 6, 7, 5, 4, 2, 4, 6, 65, 6, 11};
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(a, 3)));
        System.out.println(Arrays.toString(new Solution1().maxSlidingWindow(a, 3)));
    }
}
