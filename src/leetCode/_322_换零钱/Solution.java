package leetCode._322_换零钱;

import java.util.Arrays;

public class Solution {
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        mincoin(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void mincoin(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            mincoin(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }
}
