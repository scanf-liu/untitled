package leetCode_other._179_最大数;

import java.util.Arrays;


public class Solution {
    public String largestNumber(int[] nums) {
        String[] numsHelper = new String[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            numsHelper[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsHelper, (i, j)->{
            return (j+i).compareTo((i+j));
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < nums.length ; i++){
            sb.append(numsHelper[i]);
        }
        String ans  = sb.toString();
        if(ans.charAt(0) == '0') return "0";
        return ans;
    }
}