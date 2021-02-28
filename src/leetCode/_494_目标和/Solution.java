package leetCode._494_目标和;


//把所有符号为正的数总和设为一个背包的容量，容量为x；把所有符号为负的数总和设为一个背包的容量，容量为y。在给定的数组中，有多少种选择方法让背包装满。令sum为数组的总和，则x+y = sum。而两个背包的差为S,则x-y=S。从而求得x=(S+sum)/2。
//        基于上述分析，题目转换为背包问题：给定一个数组和一个容量为x的背包，求有多少种方式让背包装满。
//        题解代码如下：
//
//        作者：inkblack
//        链接：https://leetcode-cn.com/problems/target-sum/solution/huan-yi-xia-jiao-du-ke-yi-zhuan-huan-wei-dian-xing/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // 背包容量为整数，sum+S为奇数的话不满足要求
        if ((sum + S) % 2 == 1) {
            return 0;
        }
        // 目标和不可能大于总和
        if (S > sum) {
            return 0;
        }
        int len = (sum + S) / 2;
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = len; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[len];
    }
}

