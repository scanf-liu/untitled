package 面试题._连续最大和_循环;

public class Solution {
    public int cal(int[] nums, int k){
        if(k >= nums.length) return 1;
        int sum = 0;
        for(int i = 0 ;i < k ; i++){
            sum += nums[i];
        }
        int ans = 1;
        int maxSum = sum;
        for(int i = 1; i < nums.length; i++){
            sum = sum - nums[i-1] + nums[(i+k-1)%nums.length];
            System.out.print(sum+",");
            if(sum > maxSum){
                maxSum = sum;
                ans = i+1;
            }
        }
        System.out.println();
        return  ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cal(new int[]{5,2,3,4,5,6,7,8,9,4,3,100}, 400));
    }
}
