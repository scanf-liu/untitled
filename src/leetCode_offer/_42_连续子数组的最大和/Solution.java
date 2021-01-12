package leetCode_offer._42_连续子数组的最大和;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0] ;
        int helper = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(helper > 0) helper = helper+nums[i];
            else helper = nums[i];
            if(max < helper) max = helper;
        }
        return max;
    }
}