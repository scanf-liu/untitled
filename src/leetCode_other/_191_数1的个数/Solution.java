package leetCode_other._191_数1的个数;


/**/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0 && ans++ != -1) n = n&(n-1);
        return ans;
    }
}
