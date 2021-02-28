package leetCode_offer._65_不用加号实现两数和;

public class Solution {
    public int add(int a, int b) {
        int ans = 0;
        int c = 0;
        for (int i = 0; i < 32; i++) {
            ans += ((a & 1) ^ (b & 1) ^ c) << i;
            c = ((a & 1) & (b & 1)) | ((a & 1) & c) | ((b & 1) & c);
            a = a >> 1;
            b = b >> 1;
        }
        return ans;
    }
}
