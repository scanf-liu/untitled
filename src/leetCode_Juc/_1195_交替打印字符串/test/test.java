package leetCode_Juc._1195_交替打印字符串.test;

import leetCode_Juc._1195_交替打印字符串.api.FizzBuzz;

public class test {
    public void solve(FizzBuzz fizzBuzz){
        new Thread(()->{
            try{
                fizzBuzz.buzz(()-> System.out.print("buzz,"));
            }catch (Exception e){}
        }).start();
        new Thread(()->{
            try{
                fizzBuzz.fizz(()-> System.out.print("fizz,"));
            }catch (Exception e){}
        }).start();
        new Thread(()->{
            try{
                fizzBuzz.fizzbuzz(()-> System.out.print("fizzbuzz,"));
            }catch (Exception e){}
        }).start();
        new Thread(()->{
            try{
                fizzBuzz.number((a)-> System.out.print(a+","));
            }catch (Exception e){}
        }).start();

    }
}
