package leetCode_offer._66_构建乘积数组;

public class Solution2 {
    public int[] constructArr(int[] a) {
        if (a.length == 0) return a;
        int[] ans = new int[a.length];
        helper(a, ans, 0, a.length - 1);
        return ans;
    }

    public int helper(int[] a, int[] ans, int start, int end) {
        if (start == end) {
            ans[start] = 1;
            return a[start];
        }
        if (start == end - 1) {
            ans[start] = a[end];
            ans[end] = a[start];
            return a[end] * a[start];
        }
        int middle = (start + end) / 2;
        int cons_1 = helper(a, ans, start, middle);
        int cons_2 = helper(a, ans, middle + 1, end);
        for (int i = start; i <= middle; i++) {
            ans[i] *= cons_2;
        }
        for (int i = middle + 1; i <= end; i++) {
            ans[i] *= cons_1;
        }
        return cons_1 * cons_2;

    }
}