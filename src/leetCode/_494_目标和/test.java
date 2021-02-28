package leetCode._494_目标和;

public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 6, 7, 3, 6, 8};
        System.out.println(new Solution().findTargetSumWays(a, 8));
        System.out.println(new Solution2().findTargetSumWays(a, 8));
        System.out.println(new Solution3().findTargetSumWays(a, 8));
    }
}
