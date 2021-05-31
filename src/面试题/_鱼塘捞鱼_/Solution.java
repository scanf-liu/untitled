package 面试题._鱼塘捞鱼_;

import java.util.Arrays;

public class Solution {
    public int cal(int[] a, int[] cost, int MP, int MAX_MP, int x, int b, int index){
        if(MP < 0) return -10000000;
        if(index >= a.length) return 0;
        MP = Math.min(MAX_MP, MP+x);
        int[] ans = new int[a[index]+1];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = i + cal(a, cost, MP - i*cost[index], MAX_MP + b*i,x,b,index+1);
        }
        Arrays.sort(ans);
        return ans[ans.length-1];
    }

    public static void main(String[] args) {
        int[] a = {3,4};
        int[] cost = {4,2};
        System.out.println(new Solution().cal(a, cost, 12, 12, 4, 0, 0));
    }
}
