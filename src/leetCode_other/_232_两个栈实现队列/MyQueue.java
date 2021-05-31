package leetCode_other._232_两个栈实现队列;

import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Integer> listPut;
    private LinkedList<Integer> listOut;


    /** Initialize your data structure here. */
    public MyQueue() {
        listPut = new LinkedList<>();
        listOut = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(listOut.size() > 0){
            listPut.addLast(listOut.removeLast());
        }
        listPut.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(listPut.size() > 0){
            listOut.addLast(listPut.removeLast());
        }
        return listOut.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        while(listPut.size() > 0){
            listOut.addLast(listPut.removeLast());
        }
        return listOut.getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return listOut.size() == 0 && listPut.size() == 0;
    }
}