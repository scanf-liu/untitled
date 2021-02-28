package leetCode_offer._59_滑动窗口的最大值;

import java.util.LinkedList;

public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || (nums.length - k + 1) <= 0) return new int[0];

        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < k - 1; i++) {
            add(list, k, nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            ans[i - k + 1] = add(list, k, nums[i]);
        }
        return ans;
    }

    public int add(LinkedList<Integer> list, int k, int num) {
        while (list.size() > 0 && list.getFirst() < num) {
            list.removeFirst();
        }
        while (list.size() < k) {
            list.addFirst(num);
        }
        return list.removeLast();
    }
}