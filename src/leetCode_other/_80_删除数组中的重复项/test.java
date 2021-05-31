package leetCode_other._80_删除数组中的重复项;


import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(Arrays.toString(a));
        int l = new Solution().removeDuplicates(a);
        System.out.println(Arrays.toString(a));
        System.out.print("[");
        for(int i = 0 ; i < l ; i++){
            System.out.print(a[i]+", ");
        }
        System.out.println("]");
    }
}
