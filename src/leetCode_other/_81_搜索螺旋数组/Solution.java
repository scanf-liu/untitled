package leetCode_other._81_搜索螺旋数组;
/*81. 搜索旋转排序数组 II
已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。

给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。



示例 1：

输入：nums = [2,5,6,0,0,1,2], target = 0
输出：true
示例 2：

输入：nums = [2,5,6,0,0,1,2], target = 3
输出：false*/
public class Solution {
    int[] nums;
    int target;
    boolean flag = false;
    public boolean search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if(nums[0] == target || nums[nums.length-1] == target) return true;
        return helper(0, nums.length-1);
    }
    public boolean helper(int start, int end){
        if(flag) return flag;
        if(start > end || end > nums.length || start < 0) return false;
        if(start == end){
            flag = nums[start] == target;
            return flag;
        }

        if(nums[start] >= nums[end]){
            //循环数组
            if(nums[start] > target && nums[end] < target) return false;
            else{
                int mid = (start + end) / 2;
                if(target == nums[mid]) {
                    flag = true;
                    return true;
                }
                else return helper(start, mid-1) || helper(mid+1, end);
            }
        }else{
            //普通数组
            if(nums[start] > target || nums[end] < target) return false;
            else{
                int mid = (start + end) / 2;
                if(target == nums[mid]) {
                    flag = true;
                    return true;
                }
                else return helper(start, mid-1) || helper(mid+1, end);
            }
        }
    }
}