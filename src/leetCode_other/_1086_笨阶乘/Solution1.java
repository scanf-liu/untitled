package leetCode_other._1086_笨阶乘;

public class Solution1 {
    public int clumsy(int N) {
        int ans = 0;
        if(N >= 3){
            ans += N * (N-1) / (N-2);
            N -= 3;
        }else if( N == 2){
            ans += N * (N-1);
            return ans;
        }else if( N == 1){
            return 1;
        }



        while(N > 0){
            ans += N;
            N--;
            if(N >= 3){
                ans -= N * (N-1) / (N-2);
                N -= 3;
            }else if( N == 2){
                ans -= N * (N-1);
                return ans;
            }else if( N == 1){
                ans -=  N;
                return ans;
            }

        }
        return ans ;
    }
}