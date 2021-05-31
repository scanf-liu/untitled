package leetCode_other._368_最大整除子集;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    HashMap<Integer, LinkedList<Integer>> map= new HashMap<>();
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> a = helper(nums, 0, 1);
        a.removeFirst();
        return a;
    }

    public LinkedList<Integer> helper(int[] nums, int index, int previous){
        if(map.containsKey(previous)) return new LinkedList<>(map.get(previous));

        LinkedList<Integer> ans= new LinkedList<>();
        if(index >= nums.length){
            ans.addFirst(previous);
            return ans;
        }

        for(int i = index ; i < nums.length ; i++){
            if(nums[i] % previous == 0){
                LinkedList<Integer> temp = helper(nums, i+1, nums[i]);
                if(temp.size() > ans.size()) ans = temp;
            }
        }
        ans.addFirst(previous);
        map.put(previous, new LinkedList<>(ans));

        return ans;

    }
}