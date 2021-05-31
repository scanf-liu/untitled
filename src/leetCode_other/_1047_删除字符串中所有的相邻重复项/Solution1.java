package leetCode_other._1047_删除字符串中所有的相邻重复项;

public class Solution1 {
    public String removeDuplicates(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(stringBuilder.length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) == S.charAt(i))
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            else stringBuilder.append(S.charAt(i));
        }
        return stringBuilder.toString();
    }
}