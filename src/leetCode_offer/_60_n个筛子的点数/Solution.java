package leetCode_offer._60_n个筛子的点数;

public class Solution {
    public double[] dicesProbability(int n) {
        double[] ans = new double[]{1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double[] helper = new double[i * 6 - i + 1];
            for (int j = 0; j < ans.length; j++) {
                for (int k = 1; k <= 6; k++) {
                    helper[j + k - 1] += ans[j] / 6;
                }
            }
            ans = helper;
        }
        return ans;
    }
}