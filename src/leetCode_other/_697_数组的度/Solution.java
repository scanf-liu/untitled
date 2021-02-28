package leetCode_other._697_数组的度;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] start = new int[50000];
        int[] end = new int[50000];
        int max = 0, ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (max < count[nums[i]]) max = count[nums[i]];
            end[nums[i]] = i;
            if (start[nums[i]] == 0) start[nums[i]] = i + 1;
        }
        if (max == 1) return 1;
        for (int i = 0; i < 50000; i++) {
            if (count[i] == max) ans = Math.min(ans, end[i] - start[i] + 2);
        }
        return ans;
    }
}