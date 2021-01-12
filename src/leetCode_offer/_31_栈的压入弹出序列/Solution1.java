package leetCode_offer._31_栈的压入弹出序列;

import java.util.LinkedList;

public class Solution1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int pushed_flag = 0;
        int popped_flag = 0;
        if(pushed.length == 0) return true;
        //stack.addFirst(pushed[0]);
        while(pushed_flag < pushed.length && popped_flag < pushed.length){
            if(stack.size() == 0 || stack.getFirst() != popped[popped_flag]){
                stack.addFirst(pushed[pushed_flag]);
                pushed_flag++;
                //continue;
            }else{
                stack.removeFirst();
                popped_flag++;
            }
        }
        while(stack.size() != 0){
            if(stack.removeFirst() == popped[popped_flag]) popped_flag++;
            else return false;
        }
        return true;
    }
}