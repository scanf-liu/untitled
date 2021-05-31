package leetCode_other._59_螺旋矩阵;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。


import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int temp = 1, sub = 0;
        while(2*sub < n){
            for(int i = sub; i < n-sub; i++){
                ans[sub][i] = temp;
                temp++;
            }
            for(int j = 1+sub; j < n-sub; j++){
                ans[j][n-1-sub] = temp;
                temp++;
            }
            for(int i = n-sub-2; i >= sub; i--){
                ans[n-1-sub][i] = temp;
                temp++;
            }
            for(int j = n-sub-2; j >= 1+sub; j--){
                ans[j][sub]= temp;
                temp++;
            }
            sub++;
            //System.out.println(Arrays.deepToString(ans));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = new Solution().generateMatrix(10);
        for(int[] i : a){
            System.out.println(Arrays.toString(i));
        }
    }
}