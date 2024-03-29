package leetCode_other._1190_反转每对括号间的子串;

import java.util.LinkedList;
/*1190. 反转每对括号间的子串
给出一个字符串 s（仅含有小写英文字母和括号）。

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

注意，您的结果中 不应 包含任何括号。



示例 1：

输入：s = "(abcd)"
输出："dcba"
示例 2：

输入：s = "(u(love)i)"
输出："iloveu"
示例 3：

输入：s = "(ed(et(oc))el)"
输出："leetcode"
示例 4：

输入：s = "a(bcdefghijkl(mno)p)q"
输出："apmnolkjihgfedcbq"*/
public class Solution {
    public String reverseParentheses(String s) {
        LinkedList<StringBuilder> list = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            StringBuilder ss = new StringBuilder();
            if(temp == '('){
                count++;
                ss.append(temp);
                list.add(ss);
            }else if(temp == ')'){
                if((count & 1) == 1){
                    while(!list.getLast().toString().equals("(")){
                        ss.append(list.removeLast());
                    }
                    list.removeLast();
                    list.add(ss);
                }else{
                    while(!list.getLast().toString().equals("(")){
                        ss = list.removeLast().append(ss);
                    }
                    list.removeLast();
                    list.add(ss);
                }
                count--;
            }else{
                ss.append(temp);
                list.add(ss);
            }
        }

        if(list.size() > 1){
            StringBuilder sss = new StringBuilder();
            while(list.size() > 0){
                sss = list.removeLast().append(sss);
            }
            return sss.toString();
        }
        return list.removeLast().toString();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
}
