package leetCode_other._1250_检查好数组;

public class Solution {
    public boolean isGoodArray(int[] nums) {
        int len = nums.length, res = nums[0];
        for (int i = 1; i < len; i++) {
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }

    public int gcd(int a, int b) {
        if (a <= 0 || b <= 0) {
            return 0;
        }
        int t = Math.max(a, b);
        b = Math.min(a, b);
        a = t;
        while (t > 0) {
            t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}