package leetCode_offer._51_数组中的逆序对;

/*剑指 Offer 51. 数组中的逆序对
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

示例 1:
    输入: [7,5,6,4]
    输出: 5
*/

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 6, 2, 6, 74, 6, 74, 3, 645, 563, 57};
        System.out.println(new Solution().reversePairs(a));
    }

}
