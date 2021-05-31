package leetCode_other._354_俄罗斯套娃信封;

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] a, int b[])->{
            if(a[0] > b[0]) return 1;
            else if(a[0] < b[0]) return -1;
            else return b[1] - a[1];
        });
        //System.out.println(Arrays.deepToString(envelopes));
        int n = envelopes.length;
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);

    }
    /* 返回 nums 中 LIS 的长度 */
    public int lengthOfLIS(int[] nums) {
        int piles = 0, n = nums.length;
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            int left = 0, right = piles;
            // 二分查找插入位置
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] >= poker)
                    right = mid;
                else
                    left = mid + 1;
            }
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

}