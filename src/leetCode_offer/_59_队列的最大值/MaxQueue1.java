package leetCode_offer._59_队列的最大值;

import java.util.LinkedList;

public class MaxQueue1 {

    LinkedList<Integer> list;
    LinkedList<Integer> helper;

    public MaxQueue1() {
        list = new LinkedList<>();
        helper = new LinkedList<>();
    }

    public int max_value() {
        if (helper.size() == 0) return -1;
        return helper.getLast();
    }

    public void push_back(int value) {
        list.addFirst(value);
        while (helper.size() > 0 && helper.getFirst() < value) helper.removeFirst();
        while (helper.size() != list.size()) helper.addFirst(value);
    }

    public int pop_front() {
        if (helper.size() == 0) return -1;
        helper.removeLast();
        return list.removeLast();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */