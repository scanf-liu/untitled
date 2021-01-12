package leetCode._309_最佳买卖股票含冷冻期;

//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
//
//        设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
//
//        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
//        示例:
//
//        输入: [1,2,3,0,2]
//        输出: 3
//        解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


/*
buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);//维持第i-1天买入的状态，或者在第i-2天卖掉的情况下买入第i天股票
sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);//维持第i-1天卖掉的状态，或者在第i-1天买入的情况下第i天卖掉
边界条件：

buy[0] = - prices[0];
sell[0] = 0;
buy[1] = Math.max(buy[0], - prices[1]);//buy[1]选择-prices[0]和-prices[1]中的较大值,因为如果第1天为buy状态，之前不会存在卖的操作
sell[1] = Math.max(sell[0], buy[0] + prices[1]);

作者：da-shi-shuo
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/liang-ge-zhuang-tai-de-jian-dan-dong-tai-gui-hua-j/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*
*/


class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = - prices[0];
        sell[0] = 0;
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for (int i = 2; i < prices.length; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
        }
        return sell[prices.length - 1];
    }
}
