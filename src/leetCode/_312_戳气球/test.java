package leetCode._312_戳气球;




/*按照方法一的思路，我们发现我们可以通过变换计算顺序，从「自顶向下」的记忆化搜索变为「自底向上」的动态规划。

令 dp[i][j]dp[i][j] 表示填满开区间 (i,j)(i,j) 能得到的最多硬币数，那么边界条件是 i \geq j-1i≥j−1，此时有 dp[i][j]=0dp[i][j]=0。

可以写出状态转移方程：

dp[i][j]= {k = i + 1}->{j - 1} max(  val[i] · val[k] · val[j] + dp[i][k] + dp[k][j]) i < j - 1
dp[i][j]= 0 else
​
 val[i]×val[k]×val[j]+dp[i][k]+dp[k][j],
0,
​

i<j−1
i≥j−1
​


最终答案即为 dp[0][n+1]dp[0][n+1]。实现时要注意到动态规划的次序。

作者：LeetCode-MyHashMap
链接：https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/


public class test {
    public static void main(String[] args) {
        int[] a = new int[]{5, 9, 8, 5, 5, 54, 5, 14, 5};
        Solution s = new Solution();
        System.out.println(s.maxCoins(a));
    }
}
