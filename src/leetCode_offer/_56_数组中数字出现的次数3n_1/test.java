package leetCode_offer._56_数组中数字出现的次数3n_1;

/*剑指 Offer 56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

示例 1：
输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1*/
public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 4, 4, 7, 8, 8, 8, 7, 7};
        System.out.println(new Solution().singleNumber(a));
        System.out.println(new Solution1().singleNumber(a));
        System.out.println(new Solution2().singleNumber(a));
    }
}
