package leetCode_other._1438_绝对值差不超过限制的最长连续子数组;

import java.util.LinkedList;

public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 1;
        int temp = 1;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        max.add(0);
        min.add(0);
        for (int i = 1; i < nums.length; i++) {
            while (max.size() != 0 && nums[i] >= nums[max.getLast()]) max.removeLast();
            max.addLast(i);
            while (min.size() != 0 && nums[i] <= nums[min.getLast()]) min.removeLast();
            min.addLast(i);
            if (nums[max.getFirst()] - nums[min.getFirst()] <= limit) {
                temp++;
            } else {
                int helper = 0;
                while (nums[max.getFirst()] - nums[min.getFirst()] > limit) {
                    if (max.getFirst() < min.getFirst()) helper = max.removeFirst();
                    else helper = min.removeFirst();
                }
                temp = i - helper;
            }
            if (temp > ans) ans = temp;
        }


        return ans;
    }
}