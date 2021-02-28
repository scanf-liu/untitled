package leetCode_other._567_字符串的排列;

/*567. 字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").


示例2:

输入: s1= "ab" s2 = "eidboaoo"
输出: False*/

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int count = s1.length();
        int[] helper = new int[26];
        int[] helper_count = new int[26];
        char[] s11 = s1.toCharArray();
        char[] s22 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            helper[s11[i] - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            helper_count[s22[i] - 'a']++;
            if (helper[s22[i] - 'a'] > 0 && helper_count[s22[i] - 'a'] <= helper[s22[i] - 'a']) {
                count--;
            }
        }
        if (count == 0) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            helper_count[s22[i] - 'a']++;
            if (helper[s22[i] - 'a'] > 0 && helper_count[s22[i] - 'a'] <= helper[s22[i] - 'a']) {
                count--;
            }
            helper_count[s22[i - s1.length()] - 'a']--;
            if (helper[s22[i - s1.length()] - 'a'] > 0 && helper_count[s22[i - s1.length()] - 'a'] < helper[s22[i - s1.length()] - 'a']) {
                count++;
            }
            if (count == 0) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab", "dfasdfaasfadfsafadaabfs"));
    }
}