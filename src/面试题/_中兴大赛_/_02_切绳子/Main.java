package 面试题._中兴大赛_._02_切绳子;
/*链接：https://ac.nowcoder.com/acm/contest/12949/B
来源：牛客网

牛牛有一条长度为{n}n的绳子。
第一天，绳子的长度为{n}n。
第二天，这条绳子会被切成两段长度分别为\lfloor\frac{n}{2}\rfloor,n-\lfloor\frac{n}{2}\rfloor⌊
2
n
​
 ⌋,n−⌊
2
n
​
 ⌋。
第三天，对于第二天切出来的每段长度大于{1}1的绳子，设其长度为{m}m，牛牛又会将其切成\lfloor\frac{m}{2}\rfloor,m-\lfloor\frac{m}{2}\rfloor⌊
2
m
​
 ⌋,m−⌊
2
m
​
 ⌋。
如此反复切下去... ...
但是，牛牛知道，终有一天所有的绳子都会被切成长度为{1}1的绳子，到时候他就没有绳子可切了。所有绳子都变成长度为{1}1的绳子是第几天？
注：{\lfloor\frac{n}{2}\rfloor}⌊
2
n
​
 ⌋表示{n}n除以{2}2向下取整。
输入描述:
输入包含{T}T组数据，第一行一个整数{T}T。
接下来{T}T行每行一个正整数{n}n。
输出描述:
输出{T}T行，第{i}i行为第{i}i组数据的答案。
示例1
输入
复制
3
1
2
3
输出
复制
1
2
3*/
import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();

        int[] aa = new int[n];
        for(int i = 0 ; i < n ; i++) aa[i] = r.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(new Main().cal(aa[i]));
        }

    }

    int ans = 1;
    public int cal(int i){
        if(i <= 1 ) return ans;
        ans++;
        cal(i - (i>>1));
        return ans;
    }
}
