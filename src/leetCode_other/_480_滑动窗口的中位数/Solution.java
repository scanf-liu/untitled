package leetCode_other._480_滑动窗口的中位数;

import java.util.Arrays;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int index = 0;
        double[] result = new double[nums.length + 1 - k];
        int[] sort = Arrays.copyOf(nums, k);
        Arrays.sort(sort);
        result[index++] = sort[k / 2] * 0.5 + sort[(k - 1) / 2] * 0.5;
        for (int i = k; i < nums.length; i++) {
            int tmp = binSearch(sort, nums[i - k]);
            insert(sort, tmp, nums[i]);
            result[index++] = sort[k / 2] * 0.5 + sort[(k - 1) / 2] * 0.5;
        }
        return result;
    }

    private void insert(int[] sortArr, int index, int target) {
        if (index == 0 || (index + 1 < sortArr.length && target > sortArr[index + 1])) {//往后插入
            int i = index + 1;
            while (i < sortArr.length && sortArr[i] < target) {
                sortArr[i - 1] = sortArr[i];
                i++;
            }
            sortArr[i - 1] = target;
        } else if (index == sortArr.length - 1 || (index > 0 && target < sortArr[index - 1])) {//往前插入
            int i = index - 1;
            while (i >= 0 && sortArr[i] > target) {
                sortArr[i + 1] = sortArr[i];
                i--;
            }
            sortArr[i + 1] = target;
        } else sortArr[index] = target;//直接填入
    }

    private int binSearch(int[] array, int num) {//二分查找
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == num) return mid;
            else if (array[mid] > num) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}