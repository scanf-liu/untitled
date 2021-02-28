package leetCode._1046_最后一块石头的重量;

import java.util.Arrays;

public class Solution1 {
    public int lastStoneWeight(int[] stones) {
        return crash(stones)[0];
    }

    public int[] crash(int[] stones) {
        if (stones.length <= 1) return stones;
        if (stones.length == 2) return new int[]{Math.abs(stones[0] - stones[1])};
        Arrays.sort(stones);
        if (stones[stones.length - 2] == stones[stones.length - 1]) {
            int[] ans = new int[stones.length - 2];
            System.arraycopy(stones, 0, ans, 0, stones.length - 2);
            return crash(ans);
        } else {
            stones[stones.length - 2] = stones[stones.length - 1] - stones[stones.length - 2];
            int[] ans = new int[stones.length - 1];
            System.arraycopy(stones, 0, ans, 0, stones.length - 1);
            return crash(ans);
        }

    }
}