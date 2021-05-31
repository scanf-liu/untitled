package 面试题._快速排序_;

import java.util.Arrays;

public class Solution {
    public void sort(int[] nums, int start, int end){
        if(end - start <= 0) return;
        int left = start, right = end;
        int temp = nums[start];
        while(left < right){
            while(left < right &&  temp <= nums[right]){
                right--;
            }

            if(left < right){
                nums[left] = nums[right];
                left++;
            }

            while(left < right &&  temp > nums[left]){
                left++;
            }

            if(left < right){
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = temp;
        System.out.print("start = " + start);
        System.out.println("  end = " + end);
        System.out.println(Arrays.toString(nums));
        sort(nums, start, left -1);
        sort(nums, left + 1, end);
    }


    public static void main(String[] args) {
        int[] a = new int[]{7,1,2,2,4,4,54,154,2,5};
        new Solution().sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
