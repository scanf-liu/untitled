package leetCode_offer._41_数据流中的中位数;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(11, (a,b)->(b-a));
    }

    public void addNum(int num) {
        if(min.size() == 0) max.add(num);
        else if((int)min.peek() < num) min.add(num);
        else max.add(num);
    }

    public double findMedian() {
        while(min.size() - max.size() > 1){
            max.add(min.poll());
        }
        while(max.size() - min.size() > 1){
            min.add(max.poll());
        }
        if(max.size() > min.size()) return max.peek();
        if(min.size() > max.size()) return min.peek();
        assert min.peek() != null;
        return (double)(max.peek() + min.peek())/2;
    }
}