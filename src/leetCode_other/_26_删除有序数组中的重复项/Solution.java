package leetCode_other._26_删除有序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int ans = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] != nums[ans]) nums[++ans] = nums[i];
        }
        return ans+1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int j = new Solution().removeDuplicates(a);
        for(int i = 0 ; i < j; i++){
            System.out.print(a[i]+",");
        }
    }
}