package leetCode._279_完全平方数;

/*279. 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

四平方和定理，意思是任何正整数都能表示成四个平方数的和。少于四个平方数的，像 12 这种，可以补一个 0 也可以看成四个平方数，12 = 4 + 4 + 4 + 0。知道了这个定理，对于题目要找的解，其实只可能是 1, 2, 3, 4 其中某个数。

Legendre's three-square theorem ，这个定理表明，如果正整数 n 被表示为三个平方数的和，那么 n 不等于 $ 4^a*(8b+7)$，a 和 b 都是非负整数。

换言之，如果 n == 4^a*(8b+7)n==4
a
 ∗(8b+7)，那么他一定不能表示为三个平方数的和，同时也说明不能表示为一个、两个平方数的和，因为如果能表示为两个平方数的和，那么补个 0，就能凑成三个平方数的和了。

一个、两个、三个都排除了，所以如果 n == 4^a*(8b+7)n==4
a
 ∗(8b+7)，那么 n 只能表示成四个平方数的和了。

所以代码的话，我们采取排除的方法。

首先考虑答案是不是 1，也就是判断当前数是不是一个平方数。

然后考虑答案是不是 4，也就是判断 n 是不是等于 $ 4^a*(8b+7)$。

然后考虑答案是不是 2，当前数依次减去一个平方数，判断得到的差是不是平方数。

以上情况都排除的话，答案就是 3。

作者：windliang
链接：https://leetcode-cn.com/problems/perfect-squares/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--51/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/


import java.util.HashMap;

public class Solution {
    public static int numSquares(int n) {
        return numSquaresHelper(n, new HashMap<Integer, Integer>());
    }

    private static int numSquaresHelper(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i, map) + 1);
        }
        map.put(n, count);
        return count;
    }
    public static int numSquares1(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

    public static int numSquares2(int n) {
        //判断是否是 1
        if (isSquare(n)) {
            return 1;
        }

        //判断是否是 4
        int temp = n;
        while (temp % 4 == 0) {
            temp /= 4;
        }
        if (temp % 8 == 7) {
            return 4;
        }

        //判断是否是 2
        for (int i = 1; i * i < n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    //判断是否是平方数
    private static boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

}
