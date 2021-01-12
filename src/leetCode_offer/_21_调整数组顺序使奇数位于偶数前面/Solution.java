package leetCode_offer._21_调整数组顺序使奇数位于偶数前面;

public class Solution {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            while(left < nums.length && ((nums[left] & 1) == 1)){
                left++;
            }
            while(right >= 0 && ((nums[right]&1) == 0)){
                right--;
            }

            if(left == nums.length || right < 0 || right < left) break;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }


        return nums;
    }
}