package leetCode._494_目标和;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        map.put(0,1);
        for(int i=0 ; i < nums.length ; i++){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int a = entry.getKey() + nums[i];
                int b = entry.getKey() - nums[i];
                map2.put(a, map2.getOrDefault(a, 0)+entry.getValue());
                map2.put(b, map2.getOrDefault(b, 0)+entry.getValue());
            }
            map = map2;
            map2 = new HashMap<>();
        }

        return map.getOrDefault(S,0);
    }
}
