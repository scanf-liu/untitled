package leetCode_offer._30_最小栈;

public class MinStackArray {
    private int[] data; // 栈数据
    private int maxSize; // 最大长度
    private int top; // 栈顶指针（下标）
    private int min; // 最小值

    // 构造函数
    public MinStackArray() {
        // 设置默认值
        maxSize = 10000;
        data = new int[maxSize];
        top = -1;
        min = Integer.MAX_VALUE;
    }

    // 入栈（添加元素）
    public void push(int x) {
        if (min >= x) {
            // 遇到了更小的值，记录原最小值（入栈）
            data[++top] = min;
            min = x;
        }
        // 当前值入栈
        data[++top] = x;
    }

    // 出栈（移除栈顶元素）
    public void pop() {
        if (min == data[top]) {
            min = data[--top]; // 拿到原最小值，并（将原最小值）出栈
        }
        --top; // 出栈
    }

    // 查找栈顶元素
    public int top() {
        return data[top];
    }

    // 查询最小值
    public int min() {
        return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */