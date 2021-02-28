package leetCode_offer._61_扑克牌中的顺子;

import java.util.Arrays;

public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int it = 0;
        while (nums[it] == 0) it++;
        for (int i = it + 1; i < 5; i++) {
            if (nums[i] == nums[i - 1]) return false;
            it -= nums[i] - nums[i - 1] - 1;
            if (it < 0) return false;
        }
        return true;
    }
}