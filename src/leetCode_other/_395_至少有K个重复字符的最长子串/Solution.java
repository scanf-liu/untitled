package leetCode_other._395_至少有K个重复字符的最长子串;

public class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k)
        {
            return 0;
        }
        int [] count = new int [26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)- 'a']++;
        }
        for(int i=0;i<26;i++){
            //char ca = s.charAt(i);
            //判断条件 找到小于出现k次的字符串
            if(count[i] < k && count[i] > 0)
            {
                int res = 0;
                //将字符串切分成多个小段 分别在求解
                for (String t : s.split(String.valueOf((char)('a'+i)))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        //原字符串里面没有小于k的字符串 直接返回字符串长度
        return s.length();
    }
}