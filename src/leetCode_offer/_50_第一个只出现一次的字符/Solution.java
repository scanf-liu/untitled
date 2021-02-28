package leetCode_offer._50_第一个只出现一次的字符;

public class Solution {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        if (s.length() == 1) {
            return s.charAt(0);
        }
        int len = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int first = s.indexOf(c);
            if (first < 0) {
                continue;
            }
            int last = s.lastIndexOf(c);
            if (first == last && first < len) {
                len = first;
            }
        }
        return len == s.length() ? ' ' : s.charAt(len);
    }
}