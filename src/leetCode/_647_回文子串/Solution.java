package leetCode._647_回文子串;


//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
//
//        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
//
//         
//
//        示例 1：
//
//        输入："abc"
//        输出：3
//        解释：三个回文子串: "a", "b", "c"
//        示例 2：
//
//        输入："aaa"
//        输出：6
//        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/palindromic-substrings
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



public class Solution {
    public int countSubstrings(String s) {
        int cnt=0;
        char [] str=s.toCharArray();
        for(int i=0;i<s.length();i++){
            cnt+=midwen(i,i+1,str);
            cnt+=midwen(i,i,str);
        }
        return cnt;
    }
    public int midwen(int id1,int id2,char[] s){
        int times=0;
        while (id1>=0&&id2<s.length&&s[id1]==s[id2]){
            times++;
            id1--;
            id2++;
        }
        return times;
    }
}