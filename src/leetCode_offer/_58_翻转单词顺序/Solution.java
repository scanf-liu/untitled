package leetCode_offer._58_翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        String[] helper = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = helper.length - 1; i >= 0; i--) {
            if (helper[i].length() == 0) continue;
            ans.append(helper[i]);
            ans.append(" ");
        }
        //if(helper.length > 0 && helper[0].length() != 0) ans.append(helper[0]);
        return ans.toString().trim();
    }
}