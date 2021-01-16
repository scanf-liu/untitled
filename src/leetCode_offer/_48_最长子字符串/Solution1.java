package leetCode_offer._48_最长子字符串;

public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        //if(s.length() == 0) return 0;
        int max = 0;
        int temp = 0;
        int[] helper = new int[128];
        for(int i = 0 ; i < 128; i++) helper[i] = -100;
        //HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(helper[s.charAt(i)] + temp >= i){
                temp = i - helper[s.charAt(i)];
            }else temp++;
            helper[s.charAt(i)] = i;
            if(temp > max) max = temp;
        }
        return max;
    }
}