package leetCode_other._232_两个栈实现队列;

public class test {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.empty());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
