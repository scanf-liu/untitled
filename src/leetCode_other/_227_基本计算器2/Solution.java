package leetCode_other._227_基本计算器2;

import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        LinkedList<Character> chara = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        char[] sChar = s.toCharArray();
        int i = 0;
        while(i < s.length()){
            if(sChar[i] == ' '){
                i++;
                continue;
            }
            if(sChar[i] == '+' ||sChar[i] == '-' || sChar[i] == '*' || sChar[i] == '/'){
                chara.add(sChar[i]);
            }else{
                int j = i;
                while(j < s.length() && sChar[j] >= '0' && sChar[j] <= '9'){
                    j++;
                }
                int temp = Integer.valueOf(s.substring(i,j));
                if(chara.size() > 0 && chara.getLast() == '/' ){
                    temp = num.removeLast() / temp;
                    chara.removeLast();
                }else if(chara.size() > 0 && chara.getLast() == '*' ){
                    temp = num.removeLast() * temp;
                    chara.removeLast();
                }

                if(chara.size() > 0 && chara.getLast() == '-' ){
                    num.add(-temp);
                    chara.removeLast();
                    chara.add('+');
                }else{
                    num.add(temp);
                }

                i = j - 1;
            }
            i++;
        }
        int ans = 0;
        for(Integer ii : num){
            ans +=ii;
        }
        return ans;

    }
}