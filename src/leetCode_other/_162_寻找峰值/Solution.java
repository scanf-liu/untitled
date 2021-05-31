package leetCode_other._162_寻找峰值;
/*162. 寻找峰值
峰值元素是指其值大于左右相邻值的元素。

给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。



示例 1：

输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。
示例 2：

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5
解释：你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。*/
public class Solution {
    int ans = -1;
    public int findPeakElement(int[] nums) {

        judge(nums, 0);
        judge(nums, nums.length-1);
        helper(nums, 0, nums.length-1);
        return ans;
    }
    public void helper(int[] nums, int start, int end){
        if(ans != -1) return;
        if(start > end || start < 0 || end >= nums.length) return;
        int mid = (start + end) / 2;
        if(judge(nums, mid)) return;

        if(mid > 0 && mid < nums.length-1){
            if(nums[mid-1] > nums[mid+1])  helper(nums,start,mid-1);
            else helper(nums,mid+1,end);
        }else{
            helper(nums,start,mid-1);
            helper(nums,mid+1,end);
        }

    }
    public boolean judge(int[] nums , int temp){
        if(temp > 0 && nums[temp] < nums[temp-1]) return false;
        if(temp < nums.length-1 && nums[temp] < nums[temp+1]) return false;
        ans = temp;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}