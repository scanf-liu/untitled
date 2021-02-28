package leetCode._76_最小覆盖子串;

/*给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。

 

示例：

输入：S = "ADOBECODEBANC", T = "ABC"
输出："BANC"
 

提示：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-window-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


创建 int[128];

*/


public class test {
    public static void main(String[] args) {
        System.out.println(Solution.minWindow("BA", "A"));
    }
}

class Solution {
    public static String minWindow(String s, String t) {
        // 发现字符串的题 很多情况都是找子串问题
        // 问题：如何从字符串中找到目标子串
        // 滑动窗口
        // 方法：整型数组存放 Char， Char 的 int 值范围为 0 ~ 127
        // 利用数组 window 存放窗口中字符个数
        // 利用数组 need 存放匹配子串中需要的字符个数

        // 如果字符串为空，或者长度小于需要匹配的长度
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        // 窗口中已经匹配的字符个数
        int count = 0;
        int left = 0;
        int right = 0;
        int minLength = s.length();
        String minString = "";

        // need 初始化
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            // 如果需要该字符，并且已有窗口内的字符个数 小于需要的字符个数
            if (need[ch] > 0 && need[ch] >= window[ch]) {
                count++;
            }

            // 当需要的字符都已经包含在窗口中后，开始收缩 left
            while (count == t.length()) {
                ch = s.charAt(left);
                // 当需要删除的字符，是必须留在窗口内时
                if (need[ch] > 0 && need[ch] == window[ch]) {
                    count--;
                }
                // 这边需要取 = ，因为可能一开始两个字符串就是匹配的，如 a , a return a
                if (right - left + 1 <= minLength) {
                    minLength = right - left + 1;
                    minString = s.substring(left, right + 1);
                }
                window[ch]--;
                left++;
            }
            right++;
        }

        return minString;
    }
}