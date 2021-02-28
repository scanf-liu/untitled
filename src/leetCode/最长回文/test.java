package leetCode.最长回文;
/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


public class test {
    public static void main(String[] args) {
        String s1 = "ababb";
        System.out.println(Solution.longestPalindrome(s1));
    }
}

class Solution {
    public static String longestPalindrome(String s) {

        int i = 0, j = 0;
        String s1 = new String();
        String s2 = new String();
        for (; i < s.length(); i++) {
            j = 0;
            for (; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i + j) != s.charAt(i - j)) {
                    break;
                }
                s1 = s.substring(i - j, i + j);
                System.out.println(i + "++" + j);
                System.out.println(s1);
            }
            if (s1.length() > s2.length()) {
                s2 = s1;
            }
        }
        return s2;

    }
}