package leetCode_other._778_水位上升的游泳池里面游泳;

public class Solution {
    public int swimInWater(int[][] grid) {
        boolean[][] helper = new boolean[grid.length][grid.length];
        int[] length = new int[10000];
        int[] weight = new int[10000];
        int water = 0;
        if (grid[0][0] > grid[grid.length - 1][grid.length - 1]) {
            water = grid[0][0];
            helper[0][0] = true;
        } else {
            water = grid[grid.length - 1][grid.length - 1];
            helper[grid.length - 1][grid.length - 1] = true;
            length[0] = grid.length - 1;
            weight[0] = grid.length - 1;
        }

        int index = 1;
        while (!(helper[grid.length - 1][grid.length - 1] && helper[0][0])) {
            int start = 0;
            while (start < index) {
                int i = length[start];
                int j = weight[start];
                if (i != 0 && !helper[i - 1][j] && water >= grid[i - 1][j]) {
                    helper[i - 1][j] = true;
                    length[index] = i - 1;
                    weight[index] = j;
                    index++;
                }
                if (j != 0 && !helper[i][j - 1] && water >= grid[i][j - 1]) {
                    helper[i][j - 1] = true;
                    length[index] = i;
                    weight[index] = j - 1;
                    index++;
                }
                if (i != grid.length - 1 && !helper[i + 1][j] && water >= grid[i + 1][j]) {
                    helper[i + 1][j] = true;
                    length[index] = i + 1;
                    weight[index] = j;
                    index++;
                }
                if (j != grid.length - 1 && !helper[i][j + 1] && water >= grid[i][j + 1]) {
                    helper[i][j + 1] = true;
                    length[index] = i;
                    weight[index] = j + 1;
                    index++;
                }
                start++;
            }
            water++;
        }
        return water - 1;
    }

}