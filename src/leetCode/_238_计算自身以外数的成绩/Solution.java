package leetCode._238_计算自身以外数的成绩;

class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int p = 1, q = 1;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = p;
            p *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= q;
            q *= nums[i];
        }
        return ans;
    }
}