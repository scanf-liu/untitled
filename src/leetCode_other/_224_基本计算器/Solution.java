package leetCode_other._224_基本计算器;

import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        //if(1==1) return 0;
        //if(s.length() < 1) return 0;
        LinkedList<Character> chara = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == ' ') ;
            else if(s.charAt(i) == '(') chara.addLast(s.charAt(i));
            else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                boolean flag1 = false;
                while(s.charAt(i) == '+' || s.charAt(i) == '-'){
                    if(s.charAt(i) == '-') flag1 = (!flag1);
                    i++;
                }
                i--;
                if(flag1) chara.addLast('-');
                else chara.addLast('+');
            }
            else if(s.charAt(i) == ')'){
                int temp = num.removeLast();
                while(chara.size() > 0 && chara.getLast() != '('){
                    char flag = chara.removeLast();
                    if(flag == '+'){
                        temp = temp + num.removeLast();
                    }else if(flag == '-'){
                        return -1;
                        //temp = -temp + num.removeLast();
                    }else{
                        return -1;
                    }
                }
                chara.removeLast();
                if(chara.size() > 0 && chara.getLast() == '-'){
                    num.addLast(-temp);
                    chara.removeLast();
                    chara.addLast('+');
                }else{
                    num.addLast(temp);
                }
                //num.addLast(temp);
            }else{
                int j = i;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') j++;
                if(chara.size() > 0 && chara.getLast() == '-'){
                    num.addLast(-Integer.valueOf(s.substring(i,j)));
                    chara.removeLast();
                    chara.addLast('+');
                }else{
                    num.addLast(Integer.valueOf(s.substring(i,j)));
                }

                i = j-1;
            }
            i++;
        }
        //System.out.println(chara.toString());
        //System.out.println(num.toString());
        int ans = 0;
        for(Integer ii : num){
            ans +=ii;
        }
        return ans;
        // return temp;
    }
}