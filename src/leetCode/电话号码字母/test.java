package leetCode.电话号码字母;

import java.util.ArrayList;
import java.util.List;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


遇到递归问题尝试使用 队列


*/


public class test {
    public static void main(String[] args) {
        String a = "23";
        List<String> list = Solution.letterCombinations(a);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}


class Solution {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }

        List<String> list = new ArrayList<String>();
        list.add("");

        String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            String letter = letter_map[digits.charAt(i) - '0'];
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String tmp = list.remove(0);
                for (int k = 0; k < letter.length(); k++) {
                    list.add(tmp + letter.charAt(k));
                }
            }
        }
        return list;
    }
}