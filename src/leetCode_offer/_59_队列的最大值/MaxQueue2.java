package leetCode_offer._59_队列的最大值;

public class MaxQueue2 {

    int[] array;
    int[] helper;
    int begin, end;

    public MaxQueue2() {
        array = new int[20000];
        helper = new int[20000];
        begin = 0;
        end = 0;
    }

    public int max_value() {
        if (begin == end) return -1;
        //System.out.println(begin);
        return helper[begin];
    }

    public void push_back(int value) {
        array[end++] = value;
        int array_end = end;
        while (array_end > begin && helper[array_end - 1] < value) array_end--;
        while (array_end < end) helper[array_end++] = value;
        //System.out.println(Arrays.toString(helper));
    }

    public int pop_front() {
        if (begin == end) return -1;
        //System.out.println(Arrays.toString(array));
        return array[begin++];
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */