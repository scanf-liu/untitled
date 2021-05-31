package 面试题._归并排序_;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public void merger(int[] nums, int left, int mid, int right){
        int[] temp = new int[nums.length];
        int p1 = left, p2 = mid+1, p3 = left;
        while(p1<=mid && p2<=right){
            if(nums[p1]<=nums[p2]) temp[p3++] = nums[p1++];
            else temp[p3++] = nums[p2++];
        }
        while(p1<=mid){
            temp[p3++] = nums[p1++];
        }
        while(p2<=right){
            temp[p3++] = nums[p2++];
        }

        for(int i = left; i <= right; i++){
            nums[i] = temp[i];
        }


    }
    public void spilt(int[] nums, int start, int end){
        if(start >= end) return;
        int mid = (start + end)/2;
        spilt(nums, start, mid);
        spilt(nums, mid + 1, end);
        merger(nums, start, mid, end);
    }

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        System.out.println(Arrays.toString(a));
        new MergeSort().spilt(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

}
