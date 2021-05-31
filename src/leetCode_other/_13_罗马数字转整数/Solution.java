package leetCode_other._13_罗马数字转整数;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int temp = 1000;
        char[] ss = s.toCharArray();
        for(char ch: ss){
            int te = map.get(ch);
            if(te < temp){
                temp = te;
                ans += temp;
            }else if(te == temp){
                ans += temp;
            }else{
                ans = ans - temp - temp;
                temp = te;
                ans += te;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("XXXXIV"));
    }
}