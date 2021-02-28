package leetCode_offer._57_合为固定的递增数组;

public class Solution {
    int ans_2;

    public int[] twoSum(int[] a, int target) {

        if (helper(a, 0, a.length - 1, target - a[0])) return new int[]{a[0], ans_2};
        for (int i = 1; i < a.length - 1; i++) {
            int ans = target - a[i];
            if (helper(a, i + 1, a.length - 1, ans)) return new int[]{a[i], ans_2};
        }
        return new int[2];

    }

    public boolean helper(int[] a, int left, int right, int target) {
        if (left > right) return false;
        if (a[left] > target || a[right] < target) return false;
        int mid = (left + right) / 2;
        if (a[mid] == target) {
            ans_2 = target;
            return true;
        } else if (a[mid] > target) return helper(a, left, mid - 1, target);
        else return helper(a, mid + 1, right, target);
    }
}
