package leetCode.在排序数组中查找元素的第一个和最后一个位置;
/*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/





public class test {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,4,4,4,4,9};
        int[] ans = Solution.searchRange(nums, 4);
        System.out.println(ans[0]+"    "+ans[1]);
    }
}


class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {left_bound(nums, target),right_bound(nums, target)};
        return ans;
    }
    public static int right_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else left = mid + 1;
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    public static int left_bound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left<=right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else right = mid - 1;
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
}