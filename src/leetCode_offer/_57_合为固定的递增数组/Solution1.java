package leetCode_offer._57_合为固定的递增数组;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        while (left < right) {
            int ans = nums[left] + nums[right];
            if (ans == target) return new int[]{nums[left], nums[right]};
            else if (ans > target) right--;
            else left++;
        }
        return new int[2];
    }
}
