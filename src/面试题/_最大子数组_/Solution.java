package 面试题._最大子数组_;

/*数组中不能超过m的最大两段*/

import java.util.Arrays;

public class Solution {
    public int cal(int[] nums, int m){
        int[][] helper = new int[nums.length+1][m+1];

        for(int i = 0; i < nums.length; i++){
            for (int j = 0; j < m; j++) {
                helper[i+1][j+1] = nums[i] + helper[i][j];
            }
        }
        for (int[] ints : helper) {
            System.out.println(Arrays.toString(ints));
        }
        int ans = 0;
        int max = 0;
        for(int i = nums.length ; i > 0; i--){
            for (int j = 1; j <= m; j++) {
                if(i+j <= nums.length) max = Math.max(max, helper[i+j][j]);
            }
            int temp = 0;
            for (int j = 1; j <= m; j++) {
                temp = Math.max(helper[i][j],temp);
            }
            ans = Math.max(ans , temp + max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] n = new int[]{2,4,0,4,5};
        //int[] n = new int[]{-2,-4,-9,-4,-2,-4,-3,-1,-2};
        System.out.println(new Solution().cal(n, 3));
    }
}
