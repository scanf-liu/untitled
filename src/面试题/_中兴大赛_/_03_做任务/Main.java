package 面试题._中兴大赛_._03_做任务;
/*链接：https://ac.nowcoder.com/acm/contest/12949/C
来源：牛客网

时间限制：C/C++ 1秒，其他语言2秒
空间限制：C/C++ 262144K，其他语言524288K
64bit IO Format: %lld
题目描述
假设我们有一些任务列表，任务编号从1开始。不同的任务难度也不一样，分为1-5级。
我们打算把这些任务分配给牛牛，可是牛牛比较懒，每次他接受到一个任务后，他都会从自己的todo list里找到“难度各不相同且编号和最大的五个任务”，然后再一起完成，否则的话，牛牛就把任务放到自己的todo list，什么也不做。

请你根据输入的任务列表的情况，给出牛牛完成任务的情况。
输入描述:
第一行输入一个整数\mathit nn 表示任务数目。
第二行\mathit nn个以空格分隔的整数，表示不同的任务难度。
1\leq n \leq 10^{5}1≤n≤10
5

输出描述:
输出\mathit nn行，表示牛牛每次收到任务后的完成任务情况。如果牛牛什么也没做，就输出-1，否则的话，输出5个整数，分别表示牛牛完成难度为\text 1,2,3,4,51,2,3,4,5的五个任务编号。
示例1
输入
复制
10
1 1 2 2 3 3 4 5 4 5
输出
复制
-1
-1
-1
-1
-1
-1
-1
2 4 6 7 8
-1
1 3 5 9 10*/
import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int[] aa = new int[n];
        for(int i = 0 ; i < n ; i++) aa[i] = r.nextInt();
        HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            if(!hashMap.containsKey(aa[i])) hashMap.put(aa[i], new LinkedList<>());
            hashMap.get(aa[i]).addLast(i+1);
            if(hashMap.size() >= 5){
                int[] iiii = new int[5];
                int f = 0;
                LinkedList<Integer> del = new LinkedList<>();
                for(int ttt : hashMap.keySet()){
                    LinkedList<Integer> linkedList = hashMap.get(ttt);
                    iiii[f++] = linkedList.removeLast();
                    if(linkedList.size() == 0) del.add(ttt);
                }
                //Arrays.sort(iiii);
                for(int j = 0 ; j < 5; j++){
                    System.out.print(iiii[j]+" ");
                }
                System.out.println();
                for(int delNum : del){
                    hashMap.remove(delNum);
                }
            }else{
                System.out.println("-1");
            }
        }
    }
}