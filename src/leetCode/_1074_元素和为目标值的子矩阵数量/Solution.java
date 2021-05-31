package leetCode._1074_元素和为目标值的子矩阵数量;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int[][] helper = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 1; i < helper.length; i++){
            for(int j = 1; j < helper[0].length; j++){
                helper[i][j] = helper[i-1][j] + helper[i][j-1] - helper[i-1][j-1] + matrix[i-1][j-1] ;
                // ans += (matrix[i-1][j-1]==targrt?1:0);
            }
        }
        for(int[] is: helper){
            System.out.println(Arrays.toString(is));
        }

        for(int x = 1; x <= matrix.length; x++)
            for(int y = 1; y <= matrix[0].length; y++)
                for(int i = 0; i < helper.length-x; i++)
                    for(int j = 0; j < helper[0].length-y; j++){
                        int temp = helper[i+x][j+y] - helper[i+x][j] - helper[i][j+y] + helper[i][j];
                        if(temp == target) ans++;
                        System.out.println(temp);
                    }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {{0,1,0},{1,1,1},{0,1,0}};
        System.out.println(new Solution().numSubmatrixSumTarget(a,0));
        System.out.println(new Solution1().numSubmatrixSumTarget(a,0));
    }
}

class Solution1 {
    public int numSubmatrixSumTarget(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int top = 1; top <= n; top++) {
            for (int bot = top; bot <= n; bot++) {
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int r = 1; r <= m; r++) {
                    cur = sum[bot][r] - sum[top - 1][r];
                    if (cur == t) ans++;
                    if (map.containsKey(cur - t)) ans += map.get(cur - t);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }
}
