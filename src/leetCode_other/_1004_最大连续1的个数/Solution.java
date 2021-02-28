package leetCode_other._1004_最大连续1的个数;

public class Solution {
    public int longestOnes(int[] A, int K) {

        int ans = 0;
        int fin = 0;
        int[] helper = new int[A.length];
        int begin = 0, last = 0;


        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) ans++;
            else {
                if (fin < ans) fin = ans;
                helper[last++] = i;

                if (last - begin > K) {
                    ans = i - helper[begin++];

                } else ans++;
            }
        }
        if (fin < ans) return ans;
        return fin;
    }
}