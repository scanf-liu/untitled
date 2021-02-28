package leetCode_offer._14_1_剪绳子;

public class Solution1 {
    public int cuttingRope(int n) {
        int[] ans = new int[n + 1];
        //ans[1] = 1;
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(Math.max(ans[j], j) * Math.max(ans[i - j], i - j), temp);
            }
            ans[i] = temp;
        }
        //System.out.println(Arrays.toString(ans));
        return ans[n];
    }
}