package leetCode_other._566_重塑矩阵;

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c > nums.length * nums[0].length) return nums;
        int temp = 0;
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = nums[temp / nums[0].length][temp % nums[0].length];
                temp++;
            }
        }

        return ans;
    }
}