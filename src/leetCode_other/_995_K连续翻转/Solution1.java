package leetCode_other._995_K连续翻转;

public class Solution1 {
    public int minKBitFlips(int[] A, int K) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                if (i + K > n) return -1;
                for (int j = i; j <= i + K - 1; j++)
                    A[j] ^= 1; // 手动翻转，也可写成 A[j] = 1 - A[j]; or A[j] = A[j] == 0 ? 1 : 0;
                cnt++;
            }
        }
        return cnt;
    }
}