package leetCode_other._91_解码方法;

public class Solution1 {
    int ans = 0;
    public int numDecodings(String s) {
        char[] ss = s.toCharArray();
        int[] count = new int[ss.length];
        if(ss[0] == '0') return 0;
        return helper(ss, 0, count);

    }
    public int helper(char[] s, int index, int[] count){
        if(count[index] != 0) return count[index];
        if(s[index] == '0'){
            return 0;
        }
        if(index == s.length-1){
            return 1;
        }
        int ans = 0;
        if(index == s.length-2){
            if(s[index] == '1') {
                ans = helper(s, index+1, count)+1;
                count[index] = ans;
                return ans;
            }else if(s[index] == '2' && s[index+1] <= '6'){
                ans = helper(s, index+1, count)+1;
                count[index] = ans;
                return ans;
            }
            count[index] = helper(s, index+1, count);
            return count[index];
        }else{
            if(s[index] == '1') {
                count[index] = helper(s, index+2, count);
            }else if(s[index] == '2' && s[index+1] <= '6'){
                count[index] = helper(s, index+2, count);
            }
            count[index] += helper(s, index+1, count);
            return  count[index];
        }
    }
}