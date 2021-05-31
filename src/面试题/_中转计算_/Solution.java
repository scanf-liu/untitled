package 面试题._中转计算_;

import java.util.Arrays;

public class Solution {
    public int cal(int[] nums){
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 66666);
        ans[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length && j - i <= nums[i]; j++)
                ans[j] = Math.min(ans[i] + 1, ans[j]);
        }
        System.out.println(Arrays.toString(ans));
        return ans[nums.length-1];
    }
    public static  void jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        System.out.println(steps);
    }
    public static void main(String[] args) {
        int[] a = {2,3,5,5,5,1,1,1,1,1,1,3,15,4};
        System.out.println(new Solution().cal(a));
        jump(a);
    }
}
