package leetCode._300_最长上升子序列_;

public class Solution {
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0; // res 为 tails 当前长度
        for (int num : nums) {
            int i = 0;
            int j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else
                    j = m;
            }
            tails[j] = num;
            if (res == j)
                res++;
        }
        return res;
    }

    public static int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] helper = new int[nums.length + 1];
        helper[0] = 1;
        helper[nums.length] = 1;
        for (int i = 1; i < nums.length; i++) {
            helper[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) helper[i] = Math.max(helper[j] + 1, helper[i]);
            }
            helper[nums.length] = Math.max(helper[nums.length], helper[i]);
        }
        //System.out.println(Arrays.toString(helper));
        return helper[nums.length];
    }
}
