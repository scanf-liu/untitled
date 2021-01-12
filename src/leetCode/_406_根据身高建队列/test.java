package leetCode._406_根据身高建队列;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[][] a = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        a = new Solution().reconstructQueue(a);
        for(int[] aa :a){
            System.out.println(Arrays.toString(aa));
        }
    }
}
