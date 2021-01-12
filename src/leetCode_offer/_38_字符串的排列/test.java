package leetCode_offer._38_字符串的排列;

import java.util.Arrays;
import java.util.PriorityQueue;



/*剑指 Offer 38. 字符串的排列
        输入一个字符串，打印出该字符串中字符的所有排列。



        你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。



        示例:

        输入：s = "abc"
        输出：["abc","acb","bac","bca","cab","cba"]
        剪枝法要提前剪

        */


public class test {
    public static void main(String[] args) {
        String a = "asss";
        System.out.println(Arrays.toString(new Solution().permutation(a)));
        System.out.println(Arrays.toString(new Solution1().permutation(a)));

    }
}
