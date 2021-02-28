package leetCode_offer._59_滑动窗口的最大值;

public class Solution {//模拟

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return nums;//0.预处理

        int[] res = new int[nums.length - k + 1];
        //找出滑动窗口一开始的max值，并放入res
        int max = nums[0];
        for (int j = 0; j < k; j++) {
            if (nums[j] > max) max = nums[j];
        }
        res[0] = max;
        //向后滑动
        for (int i = 1; i <= nums.length - k; i++) {
            if (nums[i - 1] == max) {//如果窗口丢掉的值是滑动前的max，就重新在窗口内找max
                max = nums[i];
                for (int j = i + 1; j < i + k; j++) {
                    if (nums[j] > max) max = nums[j];
                }
            } else {//如果窗口丢掉的值不是之前的max，就在max和新加入窗口的值之中找大的一个
                max = Math.max(max, nums[i + k - 1]);
            }
            res[i] = max;//放入res
        }
        return res;
    }
}