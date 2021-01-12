package leetCode_offer._05_替换空格;

public class Solution {
    public String replaceSpace(String s) {


        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') ans.append("%20");
            else  ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}