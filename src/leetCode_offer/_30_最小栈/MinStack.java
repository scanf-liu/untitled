package leetCode_offer._30_最小栈;

import java.util.LinkedList;

public class MinStack {

    /** initialize your data structure here. */

    LinkedList<Integer> list;
    LinkedList<Integer> helper;

    public MinStack() {
        list = new LinkedList<>();
        helper = new LinkedList<>();
        helper.addLast(Integer.MAX_VALUE);
    }

    public void push(int x) {
        list.addLast(x);
        if(x < helper.getLast()) helper.addLast(x);
        else helper.addLast(helper.getLast());
    }

    public void pop() {
        list.removeLast();
        helper.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int min() {
        return helper.getLast();
    }
}