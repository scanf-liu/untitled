package 面试题._修改回文字符串_;

public class Solution {
    public int cal(String s){
        char[] helper = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < helper.length>>1; i++) {
            if(helper[i] != helper[helper.length - 1 -i]) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().cal("abababababbaba"));
    }
}
