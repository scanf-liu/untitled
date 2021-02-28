package leetCode_offer._57_合为固定的递增数组;

public class Solution2 {
    int ans_2;

    public int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int ans = nums[left] + nums[right];
            if (ans == target) return new int[]{nums[left], nums[right]};
            while (left < right && nums[left] + nums[right] < target) left++;
            while (left < right && nums[left] + nums[right] > target) right--;

        }
        return new int[2];
    }
}
