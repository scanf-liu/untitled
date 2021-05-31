package leetCode_other._150_逆波兰表达式;

import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        int[] arr=new int[tokens.length];
        int top=-1;
        for(String obj:tokens){
            switch(obj){
                case"+":
                    arr[--top]+=arr[top+1];
                    break;
                case"-":
                    arr[--top]-=arr[top+1];
                    break;
                case"*":
                    arr[--top]*=arr[top+1];
                    break;
                case"/":
                    arr[--top]/=arr[top+1];
                    break;
                default:
                    arr[++top]=Integer.parseInt(obj);
                    break;
            }


        }
        return arr[top];
    }

    public int evalRPN1(String[] tokens) {
        LinkedList<Integer> helper = new LinkedList<>();
        for(String s: tokens){
            if(s.equals("+")){
                helper.add(helper.removeLast() + helper.removeLast());
            }else if(s.equals("-")){
                helper.add(-helper.removeLast() + helper.removeLast());
            }else if(s.equals("*")){
                helper.add(helper.removeLast()*helper.removeLast());
            }else if(s.equals("/")){
                Integer i = helper.removeLast();
                helper.add(helper.removeLast()/i);
            }else{
                helper.add(Integer.valueOf(s));
            }
        }


        return helper.getLast();
    }

}