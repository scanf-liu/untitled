package leetCode_other._978_最长湍流子数组;

/*978. 最长湍流子数组
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

返回 A 的最大湍流子数组的长度。



示例 1：

输入：[9,4,2,10,7,8,8,1,9]
输出：5
解释：(A[1] > A[2] < A[3] > A[4] < A[5])
示例 2：

输入：[4,8,12,16]
输出：2
示例 3：

输入：[100]
输出：1*/
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int ans = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((i & 1) == 1) {
                if (arr[i] > arr[i - 1]) ans++;
                else ans = 1;
            } else {
                if (arr[i] < arr[i - 1]) ans++;
                else ans = 1;
            }
            if (ans > max) max = ans;
        }
        ans = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((i & 1) == 0) {
                if (arr[i] > arr[i - 1]) ans++;
                else ans = 1;
            } else {
                if (arr[i] < arr[i - 1]) ans++;
                else ans = 1;
            }
            if (ans > max) max = ans;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
    }
}