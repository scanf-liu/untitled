package 面试题._中兴大赛_._01_跳高;
/*链接：https://ac.nowcoder.com/acm/contest/12949/A
来源：牛客网

题目描述
在新的一年，牛牛想跳得更高。牛牛本身可以跳高{h}h米。同时牛牛有{n}n颗跳高弹，使用第{i}i颗跳高弹可以使牛牛跳高高度增加a_ia
i
​
 米，且跳高弹的效果是可以叠加的，也就是说如果牛牛使用多颗跳高弹，那么他的跳高高度将会增加这些跳高弹单个效果的和。

每颗跳高弹只能使用一次。

请问牛牛最少需要使用多少个跳高弹，才能让牛牛的高度至少是{u}u米高呢？

数据保证答案存在。
输入描述:
第一行三个整数{n},{h},{u}n,h,u。(1\leq n\leq 5*10^5, 1\leq h, u\leq 10^9)(1≤n≤5∗10
5
 ,1≤h,u≤10
9
 )。
第二行n个整数a_1,...,a_na
1
​
 ,...,a
n
​
 ，(1\leq a_i\leq 10^9)(1≤a
i
​
 ≤10
9
 )。
输出描述:
输出一个整数，表示答案。
示例1
输入
复制
3 2 5
1 3 2
输出
复制
1
说明
只需要使用第2颗跳高弹就可以到达5米。*/
import java.util.Scanner;
import java.util.Arrays;
public class Main{

    public static void main(String[] args) {
        System.out.println(new Main().cal());
    }

    public int cal(){
        Scanner r = new Scanner(System.in);

        int n = r.nextInt();
        int h = r.nextInt();
        int u = r.nextInt()-h;
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = r.nextInt();
        }
        if(u <= 0) return 0;
        Arrays.sort(a);
        for(int i=0 ; i < n; i++){
            u -= a[n-1-i];
            if(u <= 0) return i+1;
        }

        return -1;

    }
}
