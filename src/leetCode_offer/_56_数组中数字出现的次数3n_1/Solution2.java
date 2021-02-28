package leetCode_offer._56_数组中数字出现的次数3n_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            Integer helper = map.getOrDefault(i, 0);
            if (helper == 2) map.remove(i);
            else map.put(i, helper + 1);
        }
        Set<Integer> values = map.keySet();//2、遍历   获得所有的value
        for (Integer integer : values) {
            return integer;
        }

        return -1;

    }
}