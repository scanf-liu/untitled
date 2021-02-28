package leetCode_offer._09_两个栈实现队列;


public class test {
    public static void main(String[] args) {
        CQueue a = new CQueue();
        a.appendTail(1);
        a.appendTail(2);
        a.appendTail(21);
        a.appendTail(221);
        a.appendTail(2221);
        System.out.println(a.deleteHead());
        System.out.println(a.deleteHead());
        System.out.println(a.deleteHead());
        System.out.println(a.deleteHead());
        System.out.println(a.deleteHead());
    }
}
