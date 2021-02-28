package leetCode.括号的生成;

import java.util.ArrayList;
import java.util.List;



/*数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class test {

    public static void main(String[] args) {
        List<String> a = Solution.generateParenthesis(3);

        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }


    }

}


class Solution {

    public static List<String> generateParenthesis(int n) {

        String s = "(";
        List<String> list = new ArrayList<String>();
        list.add(s);
        int flag, size1;
        for (int i = 0; i < n * 2 - 1; i++) {
            size1 = list.size();
            for (int j = 0; j < size1; j++) {
                s = list.remove(0);
                flag = judge(s, n);
                if (flag == 0) {
                    list.add(s + ')');
                } else if (flag == 1) {
                    list.add(s + '(');
                } else {
                    list.add(s + '(');
                    list.add(s + ')');
                }

            }
        }
        return list;
    }

    static int judge(String s, int n) {

        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') a++;
            else b++;
        }
        if (a == n) return 0;
        else if (a == b) return 1;
        else return 2;
    }


}