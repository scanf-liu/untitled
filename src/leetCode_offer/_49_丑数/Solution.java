package leetCode_offer._49_丑数;

import java.util.PriorityQueue;

public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        for (int i = 0; i < n - 1; i++) {
            Long temp = queue.poll();
            while (queue.size() > 0 && temp.compareTo(queue.peek()) == 0) queue.poll();
            queue.add(temp * 2);
            queue.add(temp * 3);
            queue.add(temp * 5);
        }
        return queue.poll().intValue();
    }
}