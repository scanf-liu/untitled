package leetCode_offer._59_队列的最大值;

public class MaxQueue {
    int[] q = new int[20000];
    int start = 0, end = 0;

    public MaxQueue() {
    }

    public int max_value() {
        int ans = -1;
        for (int i = start; i != end; i++) {
            ans = Math.max(ans, q[i]);
        }
        return ans;
    }

    public void push_back(int value) {
        q[end++] = value;
    }

    public int pop_front() {
        if (start == end) {
            return -1;
        } else {
            return q[start++];
        }
    }
}