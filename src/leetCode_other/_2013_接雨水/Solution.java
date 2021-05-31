package leetCode_other._2013_接雨水;

public class Solution {
    public int trap(int[] height) {
        int ans = 0 ;
        if(height.length <= 2) return 0;
        int[] helper = new int[height.length];
        int flag = 0;
        for(int i = 1 ; i < height.length; i++){
            while(flag >= 1 && height[helper[flag]] <= height[i]){
                int before = height[helper[flag--]];
                ans += Math.max((Math.min(height[helper[flag]],height[i]) - before)* (i - helper[flag] - 1),0);
            }
            helper[++flag] = i;
        }
        return ans;
    }
}