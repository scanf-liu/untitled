package leetCode_offer._43_统计十进制中1的个数;

public class Solution1 {
    public int countDigitOne(int n) {
        int ans = 0;
        int length = String.valueOf(n).length();
        int[] table = new int[length];
        table[0] = 1;
        for(int i = 1 ; i < length-1; i++){
            table[i] = table[i-1]*10 + (int)Math.pow(10, i);
            //System.out.println(table[i]);
        }
        int i = length - 2;
        while(i >= 0){
            int temp_num= n/(int)Math.pow(10, i+1);
            //System.out.println(temp_num);
            if(temp_num <= 0){
                i--;
                continue;
            }
            if(temp_num == 1) ans += table[i] + n%Math.pow(10, i+1)+1;
            else ans += table[i] * temp_num + Math.pow(10, i+1);
            n = n%(int)Math.pow(10, i+1);
            i--;
        }
        if(n >= 1) ans++;
        return ans;
    }

}