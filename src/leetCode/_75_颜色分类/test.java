package leetCode._75_颜色分类;

/*给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 1, 0, 0};
        Solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}


class Solution {
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right && left < right) {
            if (nums[left] == 0) {
                left++;
                continue;
            }

            if (nums[right] == 2) {
                right--;
                continue;
            }

            if (left > i) {
                i = left;
            }

            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            } else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            } else i++;
        }
        return;

    }
}
