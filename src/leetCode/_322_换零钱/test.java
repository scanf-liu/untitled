package leetCode._322_换零钱;

/*给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

你可以认为每种硬币的数量是无限的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        Solution2 s2 = new Solution2();
        int[] i = new int[]{244, 125, 459, 120, 316, 68, 357, 320};
        System.out.println(s.coinChange(i, 9793));
        System.out.println(s2.coinChange(i, 9793));
    }
}
