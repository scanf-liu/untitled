package leetCode_other._503_下一个更大元素;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for(int i = 0 ; i < nums.length*2 - 1 ; i++){
            while(list.size() > 0 && nums[list.getLast()%nums.length] < nums[i%nums.length] ){
                ans[list.removeLast()%nums.length] = nums[i%nums.length];
            }
            list.addLast(i);
        }
        return ans;
    }
}