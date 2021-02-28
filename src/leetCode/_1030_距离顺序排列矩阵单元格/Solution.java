package leetCode._1030_距离顺序排列矩阵单元格;

class Solution {
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] ans = new int[R * C][2];
        int[] helper = new int[R + C - 1];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int des = Math.abs(i - r0) + Math.abs(j - c0);
                helper[des]++;
            }
        }
        helper[0] = 0;
        for (int i = 1; i < helper.length; i++) {
            helper[i] += helper[i - 1];
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int des = Math.abs(i - r0) + Math.abs(j - c0);
                ans[helper[des]][0] = i;
                ans[helper[des]][1] = j;
                helper[des]--;
            }
        }
        return ans;
    }
}
