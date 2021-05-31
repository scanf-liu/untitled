package leetCode_other._264_找出第n个丑数;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] helper = new int[n];
        helper[0] = 1;
        int a = 0, b = 0, c = 0;
        for(int i = 1 ; i < n ; i++){
            int a1 = helper[a] * 2, b1 = helper[b] * 3, c1 = helper[c] * 5;
            helper[i] = Math.min(a1, Math.min(b1, c1));
            if(helper[i] == a1) a++;
            if(helper[i] == b1) b++;
            if(helper[i] == c1) c++;
        }
        //System.out.println(Arrays.toString(helper));
        return helper[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(15));
    }
}