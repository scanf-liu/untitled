package leetCode_other._1482_制作m束花所需要的最少天数;
/*1482. 制作 m 束花所需的最少天数
给你一个整数数组 bloomDay，以及两个整数 m 和 k 。

现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。

花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。

请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。



示例 1：

输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
输出：3
解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
现在需要制作 3 束花，每束只需要 1 朵。
1 天后：[x, _, _, _, _]   // 只能制作 1 束花
2 天后：[x, _, _, _, x]   // 只能制作 2 束花
3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3*/
public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m * k ) {
            return -1;
        }
        int left = 0 , right = Integer.MIN_VALUE,mid = 0;
        for(int day:bloomDay){
            right = Math.max(right,day);
        }
        while (left < right){
            mid = left + right >>> 1;
            if(canMake(bloomDay,k,m,mid)){
                right = mid ;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canMake(int[] bloomDays,int k,int m,int maxBloomDay){
        int n = bloomDays.length, l = 0;
        for(int i = 0;;) {
            int bloomDay = bloomDays[i++];
            if(bloomDay <= maxBloomDay) {
                if(++l == k) {
                    if (--m == 0) {
                        return true;
                    }
                    l = 0;
                }
            } else {
                if(i + m * k > n) {
                    return false;
                }
                l = 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDays(new int[]{1, 3, 41, 1, 3, 4, 54, 23, 42, 3, 4, 32, 3, 2}, 2, 3));
    }
}