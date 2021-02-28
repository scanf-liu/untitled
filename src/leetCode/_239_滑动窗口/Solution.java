package leetCode._239_滑动窗口;

import java.util.LinkedList;

public class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        //从左往右窗口的第一个最大值默认是数组第一个值
        maxLeft[0] = nums[0];
        //从右往左窗口的最后一个最大值是数组的最后一个值
        maxRight[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            //这里分别计算从前往后窗口的最大值和从后往前窗口的最大值。要搞懂这里的判断，如果
            //i % k == 0，表示到了下一个窗口
            maxLeft[i] = (i % k == 0) ? nums[i] : Math.max(maxLeft[i - 1], nums[i]);
            int j = len - i - 1;
            maxRight[j] = ((j + 1) % k == 0) ? nums[j] : Math.max(maxRight[j + 1], nums[j]);
        }
        //返回的结果值
        int[] res = new int[len - k + 1];
        for (int i = 0, j = 0; i < res.length; i++) {
            //取每个窗口内从左往右扫描的最后一个值和从右往左扫描的最后
            //一个值(如果从左边数是第一个)的最大值
            res[j++] = Math.max(maxRight[i], maxLeft[i + k - 1]);
        }
        return res;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int[] ans = new int[nums.length - k + 1];


        for (int i = 0; i < k - 1; i++) {
            while (list.size() != k) {
                if (list.size() == 0) list.addLast(nums[i]);
                else if (list.getLast() < nums[i]) list.removeLast();
                else list.addLast(nums[i]);
                //list.addLast(nums[i]);
            }
            list.removeFirst();
        }


        for (int i = 0; i < ans.length; i++) {
            while (list.size() != k) {
                if (list.size() == 0) list.addLast(nums[i + k - 1]);
                else if (list.getLast() < nums[i + k - 1]) list.removeLast();
                else list.addLast(nums[i + k - 1]);
                //list.addLast(nums[k-i+1]);
            }
            ans[i] = list.removeFirst();
        }
        return ans;
    }
}
