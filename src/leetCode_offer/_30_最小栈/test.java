package leetCode_offer._30_最小栈;

public class test {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(-1);
        obj.push(4);
        obj.push(6);
        obj.push(1);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.min());


        MinStackArray obj1 = new MinStackArray();
        obj1.push(1);
        obj1.push(-1);
        obj1.push(4);
        obj1.push(6);
        obj1.push(1);
        obj1.pop();
        System.out.println(obj1.top());
        System.out.println(obj1.min());
    }
}
