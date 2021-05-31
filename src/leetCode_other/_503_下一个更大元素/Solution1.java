package leetCode_other._503_下一个更大元素;

public class Solution1 {
    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length];
        boolean[] helper= new boolean[nums.length];
        boolean[] helper_1= new boolean[nums.length];
        if(nums.length == 0) return ans;
        helper_1[0] = true;
        for(int i = 1; i < nums.length; i++){
            helper_1[i] = true;
            for(int j = 0; j < i; j++){
                if(helper_1[i] && nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    helper_1[i] = false;
                }
                if((helper_1[j] || !helper[j]) && nums[i] > nums[j]){
                    ans[j] = nums[i];
                    helper[j] = true;
                    helper_1[j] = false;
                }
            }
            //System.out.println(Arrays.toString(ans));
        }
        for(int i = 0; i < nums.length; i++){
            if(helper_1[i]) ans[i] = -1;
        }
        return ans;
    }
}