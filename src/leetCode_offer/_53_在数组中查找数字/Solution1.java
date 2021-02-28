package leetCode_offer._53_在数组中查找数字;

public class Solution1 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int ans = 0, left = 0, right = nums.length - 1;
        int middle = right;
        while (true) {
            if (nums[left] == target) {
                middle = left;
                break;
            }
            if (nums[right] == target) {
                middle = right;
                break;
            }
            if (left > right) return 0;
            if (left == right && nums[left] != target) return 0;
            if (left == right - 1 && nums[left] != target && nums[right] != target) return 0;
            middle = (left + right) / 2;
            if (nums[middle] == target) break;
            if (nums[middle] > target) right = middle;
            else left = middle;
        }
        int mid = middle;
        int middd;
        while (true) {
            if (nums[left] == target && (left == 0 || nums[left - 1] != target)) break;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                left = mid;
                break;
            }
            middd = (mid + left) / 2;
            if (nums[middd] == target) mid = middd;
            else left = middd;
        }
        mid = middle;
        while (true) {
            if (nums[right] == target && (right == nums.length - 1 || nums[right + 1] != target)) break;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)) {
                right = mid;
                break;
            }
            middd = (mid + right) / 2;
            if (nums[middd] == target) mid = middd;
            else right = middd;
        }

        return right - left + 1;
    }
}