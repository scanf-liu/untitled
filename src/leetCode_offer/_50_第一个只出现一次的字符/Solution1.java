package leetCode_offer._50_第一个只出现一次的字符;

public class Solution1 {
    public char firstUniqChar(String s) {
        int[] helper = new int[128];
        char temp;
        for (int i = 0; i < s.length(); i++) {
            helper[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (helper[s.charAt(i)] == 1) return s.charAt(i);
        }
        return ' ';
    }
}