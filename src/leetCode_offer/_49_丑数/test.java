package leetCode_offer._49_丑数;

/*剑指 Offer 49. 丑数
我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。



示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。*/
public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1000));
        System.out.println(new Solution1().nthUglyNumber(1000));
    }
}
