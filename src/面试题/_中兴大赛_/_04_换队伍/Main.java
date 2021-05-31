package 面试题._中兴大赛_._04_换队伍;
/*换队伍
 比赛主页

 我的提交

时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 262144K，其他语言524288K
64bit IO Format: %lld
题目描述
在一个超市里有两个收银台，现在它们面前排了长长的队伍。
第一个收银台前排了\mathit n_{1}n
1
​
 个人，从靠近收银台开始分别编号\text 1,2,...,n_{1}1,2,...,n
1
​
 。
第二个收银台前排了\mathit n_{2}n
2
​
 个人，从靠近收银台开始分别编号n_{1}+1,n_{1}+2,...,n_{1}+n_{2}n
1
​
 +1,n
1
​
 +2,...,n
1
​
 +n
2
​
 。

可是总有一些人觉的自己的队伍排的太慢了，会从自己的队伍里离开，然后排在另一个队伍的最后。
那当所有的人都换完队伍后，这两个队伍的编号最后是什么样的呢？
输入描述:
第一行三个以空格分隔的整数\mathit n_{1},n_{2},qn
1
​
 ,n
2
​
 ,q。
第二行\mathit qq个以空格分隔的整数，表示离开队伍的编号。
1\leq n_{1},n_{2},q \leq 10^{5}1≤n
1
​
 ,n
2
​
 ,q≤10
5

保证离开队伍的人员编号在\text [1,n1+n2][1,n1+n2]范围内。
输出描述:
共两行整数，分别描述两个队伍的样子，按照离收银台近的位置开始依次给出人员的编号（以空格分隔）。
保证最后两个队伍均至少有一个人。
示例1
输入
复制
3 3 3
2 3 4
输出
复制
1 4
5 6 2 3
说明
初始时两个队伍的样子为：
1 2 3
4 5 6
当编号为2的人换队伍后，两个队伍的样子为：
1 3
4 5 6 2
接下来当编号为3的人换队伍后，两个队伍的样子为：
1
4 5 6 2 3
接下来当编号为4的人换队伍后，两个队伍的样子为：
1 4
5 6 2 3*/
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        int n1 = r.nextInt();
        int n2 = r.nextInt();
        int q = r.nextInt();

        Integer[] operation = new Integer[q];
        for (int i = 0; i < q; i++) {
            operation[i] = r.nextInt();
        }
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        boolean[] b = new boolean[n1+n2+1];
        boolean[] array = new boolean[n1+n2+1];
        for(int i = 1; i <= n1 ; i++){
            array[i] = true;
        }

        for (Integer integer : operation) {
            b[integer] = true;
            array[integer] = !array[integer];
        }
        boolean[] jud = new boolean[n1+n2+1];
        for(int i = q-1; i >= 0; i--){
            if(!jud[operation[i]]){
                jud[operation[i]] = true;
                if(array[operation[i]]) linkedList1.addFirst(operation[i]);
                else linkedList2.addFirst(operation[i]);
            }
        }


        for(int i = 1; i <= n1 ; i++){
            if(!b[i]) System.out.print(i+" ");
        }
        for (Integer integer : linkedList1) {
            System.out.print(integer+" ");
        }
        System.out.println();
        for(int i = 1; i <= n2 ; i++){
            if(!b[n1+i]) System.out.print((n1+i)+" ");
        }
        for (Integer integer : linkedList2) {
            System.out.print(integer+" ");
        }
    }
}
