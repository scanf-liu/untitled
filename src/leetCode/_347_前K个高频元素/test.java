package leetCode._347_前K个高频元素;

import java.util.Arrays;


/*使用最小堆*/



public class test {
    public static void main(String[] args) {
        int[] a = new int[]{14,1,44,8,95,5,6,4,1,4,1};
        Solution so = new Solution();
        System.out.println(Arrays.toString(so.topKFrequent(a,2 )));
        System.out.println(Arrays.toString(so.topKFrequent1(a,2 )));
    }
}
