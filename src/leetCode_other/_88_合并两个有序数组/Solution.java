package leetCode_other._88_合并两个有序数组;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int flag1 = m - 1;
        int flag2 = n - 1;
        for(int i = m+n-1 ; i >= 0; i--){
            if(flag1 < 0) nums1[i] = nums2[flag2--];
            else if(flag2 < 0) return;
            else if(nums1[flag1] > nums2[flag2]) nums1[i] = nums1[flag1--];
            else nums1[i] = nums2[flag2--];
        }
    }
}