package leetCode_offer._47_礼物的最大价值;

public class Solution {
    public int maxValue(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i - 1][j] > grid[i][j - 1]) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += grid[i][j - 1];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}