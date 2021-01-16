package leetCode._3_最长子序列;

/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class test {
    public static void main(String[] args) {
        String str="acvhgfjkbabbaaba";
        System.out.println(Solution.lengthOfLongestSubstring(str));
    }
}

class Solution {
    public static int lengthOfLongestSubstring(String s) {

        char[]  c = s.toCharArray();
        int answer = 0, k = 0, sameplace = s.length(), startplace = 0;
        while(k < s.length()){
            char now = c[k];
            for(int i=k+1; i<sameplace; i++){
                if( c[i]==now ){
                    sameplace = i;
                    break;
                }
            }
            k++;
            if (k == sameplace){
                answer = Math.max(sameplace - startplace,answer);
                sameplace = s.length();
                k = ++startplace;
            }

        }
        return answer;
    }
}