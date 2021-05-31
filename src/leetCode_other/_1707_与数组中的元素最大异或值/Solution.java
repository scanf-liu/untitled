package leetCode_other._1707_与数组中的元素最大异或值;

import java.util.Arrays;
import java.util.Comparator;
/*1707. 与数组中元素的最大异或值
给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。

第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。

返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。

 */
public class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int numQ = queries.length;
        int[][] newQueries = new int[numQ][3];
        for (int i = 0; i < numQ; ++i) {
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = i;
        }
        Arrays.sort(newQueries, new Comparator<int[]>() {
            public int compare(int[] query1, int[] query2) {
                return query1[1] - query2[1];
            }
        });

        int[] ans = new int[numQ];
        Trie trie = new Trie();
        int idx = 0, n = nums.length;
        for (int[] query : newQueries) {
            int x = query[0], m = query[1], qid = query[2];
            while (idx < n && nums[idx] <= m) {
                trie.insert(nums[idx]);
                ++idx;
            }
            if (idx == 0) { // 字典树为空
                ans[qid] = -1;
            } else {
                ans[qid] = trie.getMaxXor(x);
            }
        }
        return ans;
    }
}

class Trie {
    static final int L = 30;
    Trie[] children = new Trie[2];

    public void insert(int val) {
        Trie node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new Trie();
            }
            node = node.children[bit];
        }
    }

    public int getMaxXor(int val) {
        int ans = 0;
        Trie node = this;
        for (int i = L - 1; i >= 0; --i) {
            int bit = (val >> i) & 1;
            if (node.children[bit ^ 1] != null) {
                ans |= 1 << i;
                bit ^= 1;
            }
            node = node.children[bit];
        }
        return ans;
    }
}