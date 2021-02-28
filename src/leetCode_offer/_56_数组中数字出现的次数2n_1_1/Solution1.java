package leetCode_offer._56_数组中数字出现的次数2n_1_1;

import java.util.HashSet;

public class Solution1 {
    public int[] singleNumbers(int[] nums) {
        HashSet<Integer> list = new HashSet<>();
        for (int i : nums) {
            if (!list.remove(i)) list.add(i);
        }
        int[] ans = new int[2];
        int j = 0;
        for (Integer i : list) {
            ans[j++] = i;
        }
        return ans;
    }
}