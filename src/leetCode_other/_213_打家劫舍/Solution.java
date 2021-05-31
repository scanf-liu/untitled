package leetCode_other._213_打家劫舍;
/*213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。



示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。*/
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans = 0;
        int[] helper = new int[nums.length];

        //偷第一家
        helper[0] = nums[0];
        helper[1] = Math.max(nums[0],nums[1]);
        for(int i = 2 ; i < nums.length-1 ; i++){
            helper[i] = Math.max(helper[i-1], helper[i-2]+nums[i]);
        }
        ans = helper[nums.length-2];

        helper[0] = 0;
        helper[1] = nums[1];
        for(int i = 2 ; i < nums.length; i++){
            helper[i] = Math.max(helper[i-1], helper[i-2]+nums[i]);
        }

        if(ans < helper[nums.length-1]) return helper[nums.length-1];
        else return ans;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,56,3,52,5,245,2,345,235,42};
        System.out.println(new Solution().rob(a));
    }
}