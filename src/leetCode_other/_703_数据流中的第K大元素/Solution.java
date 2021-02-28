package leetCode_other._703_数据流中的第K大元素;

import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> pq;
    int k;

    public Solution(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
