package leetCode_offer._39_数组中超过一半的数字;

import java.util.Arrays;

public class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}