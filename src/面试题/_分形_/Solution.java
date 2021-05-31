package 面试题._分形_;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public int helper(int i, int j, int length){
        if(length == 2){
            if(i == 0 && j == 0) return 0;
            if(i == 1 && j == 1) return 1;
            if(i == 0 && j == 1) return 1;
            if(i == 1 && j == 0) return 1;
        }else if(length < 2) return 0;
        if(i < (length>>1) && j < length>>1) return 0;
        if(i >= length>>1) i -= length>>1;
        if(j >= length>>1) j -= length>>1;
        return helper(i, j , length>>1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int length = (int)Math.pow(2,n);
        int[][] ans = new int[length][length];
        Solution s = new Solution();
        for(int i = 0 ; i < length ; i++){
            for (int j = 0; j < length; j++) {
                ans[i][j] = s.helper(i,j,length);
            }
        }
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }

    }
}
