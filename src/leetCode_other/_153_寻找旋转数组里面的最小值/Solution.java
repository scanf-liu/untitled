package leetCode_other._153_寻找旋转数组里面的最小值;
/*154. 寻找旋转排序数组中的最小值 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

注意数组中可能存在重复的元素。

示例 1：

输入: [1,3,5]
输出: 1
示例 2：

输入: [2,2,2,0,1]
输出: 0
二分法需要考虑边界条件，防止发生一直递归的情况
用mid mid+1
或者 mid-1 , mid+1

*/
public class Solution {
    int ans = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        helper(nums, 0, nums.length-1);
        return ans;
    }
    public void helper(int[] nums, int start, int end){
        if(end < start || start < 0 || end >= nums.length)  return;
        if(start == end) ans = Math.min(ans, nums[start]);
        else if(nums[start] < nums[end]){
            ans = Math.min(ans, nums[start]);
        }else if(nums[start] == nums[end]){
            //旋转
            int mid = (start + end)/2;
            helper(nums, start+1, mid);
            helper(nums, mid+1, end);
        }else{
            //旋转
            int mid = (start + end)/2;
            helper(nums, start, mid);
            helper(nums, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,0,1,1,1,1};
        System.out.println(new Solution().findMin(nums));
    }
}