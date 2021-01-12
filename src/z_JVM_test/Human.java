package z_JVM_test;
public class Human{
    public static void main(String[] args) {
        Human2 m = new man();
        Human2 w = new woman();
        m.say();
        w.say();
    }
}
 abstract class Human2 {
     public void say(){
        System.out.println("hm");
    }
}
class man extends  Human2{
    public man() {
    }

    public void say(){
        System.out.println("m");
    }
}
class woman extends  Human2{
    public woman() {
    }

    public void say(){
        System.out.println("wm");
    }
}
