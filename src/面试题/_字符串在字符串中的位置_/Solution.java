package 面试题._字符串在字符串中的位置_;

import java.util.Arrays;
import java.util.Scanner;

/*从下标开始，走最短走几步可以*/
public class Solution {
    public int helper(char[] cha , char c, int start){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cha);
        String fa = stringBuffer.toString();
        int a = fa.indexOf(c,start);
        int b = fa.lastIndexOf(c,start-1);
        if(a == -1 && b == -1) return -1;
        if(a == -1) return b;
        if(b == -1) return a;

        if(start - a > b - start){
            return a;
        }return b;
    }

    public int cal(char[] cha, String s, int start){
        int ans = 0;
        for(int i = 0 ; i < s.length(); i++){
            int temp = new Solution().helper(cha, s.charAt(i), start) ;
            if(temp > start){
                ans += Math.min(temp - start, cha.length + start - temp);
            }else{
                ans += Math.min(start - temp, cha.length - start + temp);
            }
            start = temp;
        }

        return ans;

    }

    public static void main(String[] args) {

        //System.out.println("wwwwwwwwwsa".lastIndexOf("sa", 0));
        char[] cc = new char[]{'a','e','m','o','y','n'};
        System.out.println(new Solution().cal(cc, "amo", 0));
    }
}
