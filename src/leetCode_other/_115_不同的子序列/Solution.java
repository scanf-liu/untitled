package leetCode_other._115_不同的子序列;
/*115. 不同的子序列
给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

题目数据保证答案符合 32 位带符号整数范围。



示例 1：

输入：s = "rabbbit", t = "rabbit"
输出：3
解释：
如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
示例 2：

输入：s = "babgbag", t = "bag"
输出：5
解释：
如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
(上箭头符号 ^ 表示选取的字母)
babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^*/
public class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        int[][] dp = new int[lenS + 1][lenT + 1];

        for (int i = 0; i <= lenS; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i <= lenS; i++){
            for (int j = 1; j <= lenT; j++){
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[lenS][lenT];
    }
}