package leetCode_offer._09_两个栈实现队列;

import java.util.Stack;
//
//用栈A和栈B来实现队列，其中栈A负责插入数据，栈B负责删除数据。
//        为了实现队列先进先出的特点，在栈B为空时，需要将栈A中的数据取出插入栈B中。


public class CQueue {
    //成员变量
    Stack<Integer> A, B;

    //构造方法
    public CQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        if (B.isEmpty()) {
            if (A.isEmpty()) {
                return -1;
            }
            while (!A.isEmpty()) {
                B.push(A.pop());
            }
        }
        return B.pop();
    }
}