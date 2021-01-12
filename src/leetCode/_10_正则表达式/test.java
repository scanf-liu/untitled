package leetCode._10_正则表达式;

/*

给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/regular-expression-matching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




1.p[j - 1]p[j−1]为普通字符,若s[i - 1] == p[j - 1]s[i−1]==p[j−1]，则dp[i][j] = dp[i - 1][j - 1]dp[i][j]=dp[i−1][j−1]，否则匹配失败
2.p[j - 1]p[j−1]为'.'，则dp[i][j] = dp[i - 1][j - 1]dp[i][j]=dp[i−1][j−1]
3.p[j - 1]p[j−1]为'*'：
(1)不看，则dp[i][j] = dp[i][j - 2]dp[i][j]=dp[i][j−2]
(2)看，则dp[i][j] = dp[i - 1][j]dp[i][j]=dp[i−1][j]

作者：outvoker-c
链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/javadi-gui-yi-bu-yi-bu-de-you-hua-dao-ji-bai-100yi/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class test {
    public static void main(String[] args) {
        String a = "aaaa.*", b = "aaaabb";
        System.out.println(Solution.isMatch(b,a));


    }
}

class Solution {
    public static boolean isMatch(String s, String p) {

        char[] s1 = s.toCharArray(), p1 = p.toCharArray();
        boolean[][] dp = new boolean[s1.length+1][p1.length+1];
        dp[0][0] = true;
        for(int i = 0;i<=s1.length;i++){
            for (int j = 1; j<=p1.length;j++){
                if(p1[j-1]!='*'){
                    if (i>0 &&(s1[i-1]==p1[j-1]||p1[j-1]=='.')) dp[i][j] = dp[i - 1][j - 1];
                }else{
                    if (j>1) dp[i][j] |= dp[i][j - 2];
                    if(i > 0 && j > 1 && (s1[i - 1] == p1[j - 2] || p1[j - 2] == '.'))dp[i][j] |= dp[i - 1][j];
                }
            }
        }

        return dp[s1.length][p1.length];

    }
}