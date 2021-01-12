package leetCode_offer._03_数组中重复的数字;

public class Solution1 {
    public int findRepeatNumber(int[] nums) {
        int[] helper = new int[nums.length];
        for(int i : nums){
            if(helper[i] == 1) return i;
            else helper[i] = 1;
        }
        return -1;
    }
}