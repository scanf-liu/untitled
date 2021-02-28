package leetCode_other._992_K个不同整数的子数组;

/*而「最多存在 KK 个不同整数的子区间的个数」与「恰好存在 K 个不同整数
的子区间的个数」的差恰好等于「最多存在 K - 1K−1 个不同整数的子区间的个数」。

*/
public class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int[] helper = new int[20000];
        int count, ans = 0, right = 0, right_before = 0;
        for (int left = 0; left < A.length; left++) {
            helper = new int[20000];
            count = 0;
            right = Math.max(right_before, left);
            right_before = -1;
            for (int i = left; i < right; i++) {
                if (helper[A[i]] == 0) count++;
                helper[A[i]]++;
            }


            while (right < A.length && count <= K) {
                if (helper[A[right]] == 0) count++;
                helper[A[right]]++;
                if (count == K) {
                    ans++;
                    if (right_before == -1) right_before = right;
                }
                right++;
            }
        }


        return ans;

    }
}