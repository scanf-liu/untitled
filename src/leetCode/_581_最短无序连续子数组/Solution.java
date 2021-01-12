package leetCode._581_最短无序连续子数组;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] helper = nums.clone();
        Arrays.sort(helper);
        int start = 0, end = nums.length -1;
        while(start <= end && helper[start] == nums[start]) start++;
        while(start <= end && helper[end] == nums[end]) end--;
        return end - start + 1;
    }
}