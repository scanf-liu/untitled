package leetCode_offer._53_数组中缺失的数字;

public class Solution {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + right;
            if (nums[mid] != mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}