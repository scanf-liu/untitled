package leetCode_other._90_子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int[] helper = new int[22];
        for(int i : nums){
            helper[i+10]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        for(int i = 0; i < 22; i++){
            if(helper[i] == 0) continue;
            int size = ans.size();
            for(int j = 0 ; j < size ; j++){
                ArrayList<Integer> temp = new ArrayList<>(ans.get(j));
                for(int k = 0; k < helper[i]; k++){
                    temp.add(i-10);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
    }
}