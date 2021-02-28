package leetCode_other._1052_爱生气的书店老板;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int temp = 0;
        for(int i = 0 ; i < X; i++){
            temp += customers[i];
        }
        int ans = temp;
        int angry = X-1;
        for(int i = X; i < customers.length; i++){
            if(grumpy[i] == 0) {
                temp +=  customers[i];
                ans += customers[i];
            }
            else{
                temp += customers[i];
                if(angry + X <= i){
                    for(int j = 0 ; j < X ; j++){
                        if(grumpy[angry - j] == 1) temp -= customers[angry - j];
                    }
                }else{
                    for(int j = angry - X + 1 ; j <= i-X ; j++){
                        if(grumpy[j] == 1) temp -= customers[j];
                    }
                }
                angry = i;
            }
            if( ans < temp) ans = temp;
        }
        return ans;
    }
}