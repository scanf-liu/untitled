package leetCode._200_岛屿数量;
/*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

 

示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
示例 2：

输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

使用boolean定义 helper
*/


public class test {
    public static void main(String[] args) {
        char[][] a = new char[][]{{'1', '1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}};
        System.out.println(Solution.numIslands(a));
    }
}


class Solution {
    public static int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] helper = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (helper[i][j] == true) continue;
                if (grid[i][j] == '0') helper[i][j] = true;
                else {
                    check(grid, helper, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void check(char[][] grid, boolean[][] helper, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (helper[i][j] == true) return;
        helper[i][j] = true;
        if (grid[i][j] == '0') return;
        check(grid, helper, i - 1, j);
        check(grid, helper, i, j + 1);
        check(grid, helper, i, j - 1);
        check(grid, helper, i + 1, j);
        //System.gc();
        return;
    }
}