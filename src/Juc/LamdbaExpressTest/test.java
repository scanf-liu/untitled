package Juc.LamdbaExpressTest;

interface Foo
{
    public void say();
}

public class test {
    public static void main(String[] args) {
        Foo foo = () -> {System.out.println("hello");};
        foo.say();
        Foo foo1 = new Foo() {
            @Override
            public void say() {
                System.out.println("hhhello");
            }
        };
        foo1.say();


    }
}
