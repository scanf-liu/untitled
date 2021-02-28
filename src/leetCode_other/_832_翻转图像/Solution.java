package leetCode_other._832_翻转图像;

import java.util.Arrays;

public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ans = new int[A.length][A[0].length];
        for(int i = 0 ; i < A.length; i++){
            for(int j = 0 ; j < A[0].length; j++){
                if(A[i][j] == 0) ans[i][A[0].length-j-1] = 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] i = new int[][]{{1,0,1,1},{1,0,1,1},{1,0,1,1}};
        System.out.println(Arrays.deepToString(i));
        System.out.println(Arrays.deepToString(new Solution().flipAndInvertImage(i)));
    }
}