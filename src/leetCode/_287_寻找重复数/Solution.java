package leetCode._287_寻找重复数;

public class Solution {
    public static int findDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        do{
            int middle = (left + right)>>>1, sum = 0;
            for(int i: nums){
                if(i > left && i <= middle){
                    sum++;
                }
            }
            if(sum > middle - left) right = middle;
            else left = middle;
        }while(right - left > 1);
        return right;

    }
    public static int findDuplicate1(int[] nums) {
        int fast = nums[0], slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while(slow != fast);
        slow = nums[0];
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}