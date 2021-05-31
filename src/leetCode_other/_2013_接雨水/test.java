package leetCode_other._2013_接雨水;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(a));
        System.out.println(new Solution1().trap(a));
        System.out.println(new Solution2().trap(a));
    }
}
