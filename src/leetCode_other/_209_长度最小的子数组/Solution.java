package leetCode_other._209_长度最小的子数组;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int ans = 0;
        int end = 0;
        while(end < nums.length){
            while(sum >= target && start < end){
                if(sum >= target){
                    if(ans == 0) ans = end - start;
                    else ans = Math.min(ans, end - start);
                }
                sum -= nums[start++];
            }
            while(sum < target && end < nums.length){
                sum += nums[end++];
            }
        }
        if(sum >= target){
            while(sum >= target && start < end){
                sum -= nums[start++];
            }
            if(ans == 0) ans = end - start + 1;
            else ans = Math.min(ans, end - start + 1);
        }
        return ans;
    }
}