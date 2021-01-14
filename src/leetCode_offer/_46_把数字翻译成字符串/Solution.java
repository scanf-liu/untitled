package leetCode_offer._46_把数字翻译成字符串;

public class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] ans = new int[s.length()+1];
        ans[0] = 1;
        ans[1] = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == '1') ans[i+1] = ans[i] + ans[i-1];
            else if((s.charAt(i-1) == '2' && s.charAt(i) < '6' )) ans[i+1] = ans[i] + ans[i-1];
            else ans[i+1] = ans[i];
        }
        return ans[s.length()];
    }
}