package leetCode_other._767_重构字符串;
/*767. 重构字符串
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
注意:

S 只包含小写字母并且长度在[1, 500]区间内。*/
public class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[27];
        for(int i = 0 ; i < S.length() ; i++){
            count[S.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int before = 26;
        for (int j = 0 ; j < S.length() ;j++){
            int temp = 26;
            for(int i = 0 ; i < 26 ; i++){
                if(i == before) continue;
                if(count[i] > count[temp])  temp = i;
                //else if(count[i] == count[temp] && i != before) temp = i;
            }
            if( temp == before || count[temp] == 0) return "";
            else{
                sb.append((char) (temp+'a'));
                count[temp]--;
                before = temp;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("abb"));
    }
}