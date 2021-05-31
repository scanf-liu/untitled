package leetCode_other._2013_接雨水;

import java.util.LinkedList;

public class Solution1 {
    public int trap(int[] height) {
        int ans = 0 ;
        if(height.length <= 2) return 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for(int i = 1 ; i < height.length; i++){
            while(list.size() > 1 && height[list.getLast()] <= height[i]){
                int before = height[list.removeLast()];
                ans += Math.max(0,(Math.min(height[list.getLast()],height[i]) - before))* (i - list.getLast() - 1);
            }
            list.add(i);
        }
        return ans;
    }
}