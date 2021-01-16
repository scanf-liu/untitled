package leetCode_offer._48_最长子字符串;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int temp = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) + temp >= i){
                temp = i - map.get(s.charAt(i));
            }else temp++;
            map.put(s.charAt(i),i);
            if(temp > max) max = temp;
        }
        return max;
    }
}