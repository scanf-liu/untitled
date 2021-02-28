package leetCode_offer._17_打印从1到最大的n位数;

public class Solution {
    public int[] printNumbers(int n) {
        int helper = (int) Math.pow(10, n) - 1;
        int[] ans = new int[helper];
        for (int i = 0; i < helper; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}