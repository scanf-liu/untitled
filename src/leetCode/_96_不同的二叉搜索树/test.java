package leetCode._96_不同的二叉搜索树;


/*给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。\

二叉搜索树-》在二叉搜索树中：
1.若任意结点的左子树不空，则左子树上所有结点的值均不大于它的根结点的值。
2. 若任意结点的右子树不空，则右子树上所有结点的值均不小于它的根结点的值。
3.任意结点的左、右子树也分别为二叉搜索树。

卡特兰数是组合数学中一个常出现在各种计数问题中出现的数列。其公式为 :c(n)=c(2)*c(n-1)+c(3)*c(n-2)+...c(n-1)*c(2)。
3 -------------- 5

*/


public class test {
    public static void main(String[] args) {
        System.out.println(Solution.numTrees(4));
    }
}


class Solution {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}