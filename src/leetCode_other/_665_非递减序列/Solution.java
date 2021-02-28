package leetCode_other._665_非递减序列;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        int length = nums.length;
        for (int i = 1; i < length && cnt <= 1; i++) {
            if (nums[i] < nums[i - 1]) {
                cnt++;
                if (i >= 2 && nums[i - 2] > nums[i])
                    nums[i] = nums[i - 1];
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPossibility(new int[]{4, 3, 2, 3}));
    }
}