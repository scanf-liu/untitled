package leetCode._581_最短无序连续子数组;

//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
//        你找到的子数组应是最短的，请输出它的长度。
//
//        示例 1:
//
//        输入: [2, 6, 4, 8, 10, 9, 15]
//        输出: 5
//        解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,62,4,56,7,8,23};
        System.out.println(new Solution().findUnsortedSubarray(a));
        System.out.println(new Solution1().findUnsortedSubarray(a));
    }
}
