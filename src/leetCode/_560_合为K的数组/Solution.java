package leetCode._560_合为K的数组;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
//
//        示例 1 :
//
//        输入:nums = [1,1,1], k = 2
//        输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


/*
 * 前缀和                   索引0-7  减去 索引 0-2 就是连续索引3-7
 *
 * */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : sum) {
            ans += map.getOrDefault(i - k, 0);
            //System.out.println(map.getOrDefault(i-k,0));
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return ans;
    }
}