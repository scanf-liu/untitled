package leetCode_offer._16_数值整数次方;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (n < 0) return myPow(1 / x, -n - 1) * (1 / x);
        else {
            double ans;
            ans = myPow(x * x, n / 2);
            if ((n & 1) == 1) {
                ans *= x;
            }
            return ans;
        }
    }
}