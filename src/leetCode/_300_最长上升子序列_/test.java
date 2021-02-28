package leetCode._300_最长上升子序列_;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 5, 6, 3, 2, 2, 2, 2, 4, 4, 4, 45, 2, 2, 89,};
        System.out.println(Solution.lengthOfLIS(a));
        System.out.println(Solution.lengthOfLIS1(a));
    }
}
