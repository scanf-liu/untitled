package leetCode_offer._60_n个筛子的点数;

import java.util.Arrays;

/*剑指 Offer 60. n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]*/

public class test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dicesProbability(5)));
    }
}
