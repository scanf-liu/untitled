package leetCode_offer._45_把数组排列成最小的数;

import java.util.Arrays;
/*
此题求拼接起来的 “最小数字” ，本质上是一个排序问题。
        排序判断规则： 设 numsnums 任意两数字的字符串格式 xx 和 yy ，则
        若拼接字符串 x + y > y + xx+y>y+x ，则 m > nm>n ；
        反之，若 x + y < y + xx+y<y+x ，则 n < mn<m ；
        根据以上规则，套用任何排序方法对 numsnums 执行排序即可。
*/


public class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }
}
