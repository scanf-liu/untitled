package leetCode._338_比特位计数;

public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        if(num == 0) return ans;

        int helper = 1;
        int helper1 = 2;
        for(int i = 1 ; i <= num ;i++){
            if(i == helper1){
                helper = helper1;
                helper1 = helper1 << 1;
                ans[i] = 1;
            }else{
                ans[i] = 1 + ans[i-helper];
            }

        }
        return ans;
    }
}