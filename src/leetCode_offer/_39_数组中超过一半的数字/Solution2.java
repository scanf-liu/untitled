package leetCode_offer._39_数组中超过一半的数字;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int num = nums.length / 2 + (nums.length & 1);
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            if (count >= num) return i;
            map.put(i, count);
        }
        return -1;
    }
}