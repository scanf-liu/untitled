package leetCode_other._1047_删除字符串中所有的相邻重复项;

public class Solution {
    public String removeDuplicates(String S) {
        if(S.length() == 1) return S;
        char[] ss = S.toCharArray();
        int index = -1;
        for (char c : ss) {
            if (index != -1 && c == ss[index]) {
                index--;
            } else {
                ++index;
                ss[index] = c;
            }
        }
        return new String(ss, 0, index + 1);
    }
}