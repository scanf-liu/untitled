package leetCode_other._1310_子数组异或查询;

import java.util.Arrays;
/*1310. 子数组异或查询
有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。

对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。

并返回一个包含给定查询 queries 所有结果的数组。



示例 1：

输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
输出：[2,7,14,8]
解释：
数组中元素的二进制表示形式是：
1 = 0001
3 = 0011
4 = 0100
8 = 1000
查询的 XOR 值为：
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8*/

public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] helper = new int[arr.length+1];
        for(int i = 1; i < helper.length; i++){
            helper[i] = arr[i-1] ^ helper[i-1];
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            ans[i] = helper[queries[i][1]+1] ^ helper[queries[i][0]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] q = {{0,1},{1,2},{0,3},{3,3}};
        System.out.println(Arrays.toString(new Solution().xorQueries(arr, q)));
    }
}