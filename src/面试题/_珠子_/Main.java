package 面试题._珠子_;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        String s = r.next();
        System.out.println(new Main().cal(s));
    }
    public int cal(String s){
        int[][] count = new int[s.length()+1][7];
        for(int i = 1; i < count.length; i++){
            char temp = s.charAt(i-1);
            count[i][1] = count[i-1][1]+(temp=='1'?1:0);
            count[i][3] = count[i-1][3]+(temp=='3'?1:0);
            count[i][4] = count[i-1][4]+(temp=='4'?1:0);
            count[i][5] = count[i-1][5]+(temp=='5'?1:0);
            count[i][6] = count[i-1][6]+(temp=='6'?1:0);
        }
       // for(int[] is : count) System.out.println(Arrays.toString(is));
        int right = s.length();
        if(judge(count, right))
            return right;
        for(int i = right; i >= 0; i--){
            if(judge(count, i)) return i;
        }
        return 1;
    }

    static public boolean judge(int[][] count, int k){
        for(int i = 0; i < count.length-k; i++){
            if((count[i+k][1]-count[i][1])%2 == 0)
                if((count[i+k][3]-count[i][3])%2 == 0)
                    if((count[i+k][4]-count[i][4])%2 == 0)
                        if((count[i+k][5]-count[i][5])%2 == 0)
                            if((count[i+k][6]-count[i][6])%2 == 0)
                                return true;
        }
        return false;
    }


}