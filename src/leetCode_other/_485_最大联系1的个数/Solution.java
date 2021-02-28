package leetCode_other._485_最大联系1的个数;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int temp = 0;
        for (int i : nums) {
            if (i == 1) temp++;
            else {
                if (ans < temp) ans = temp;
                temp = 0;
            }
        }
        if (temp > ans) return temp;
        return ans;
    }
}
