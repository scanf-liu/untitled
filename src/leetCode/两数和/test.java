package leetCode.两数和;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


public class test {
    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 0, 0, 2};
        int b = 4;
        int[] c = new int[2];
        c = test.twoSum(a, b);
        System.out.println(c[0]);
        System.out.println(c[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int a[] = new int[]{i, j};
                    return a;
                }
            }
        }
        int a[] = new int[]{-1, -1};
        return a;
    }
}
