package leetCode_other._132_分割回文字符串2;
/*132. 分割回文串 II
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。

返回符合要求的 最少分割次数 。



示例 1：

输入：s = "aab"
输出：1
解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
示例 2：

输入：s = "a"
输出：0
示例 3：

输入：s = "ab"
输出：1*/
public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().minCut("ababbabababababbabnanananabbabananab"));
    }
}
