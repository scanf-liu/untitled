package leetCode_other._132_分割回文字符串2;

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] helper = new boolean[n][n];

        for(int j = 0; j < n; j++){
            for (int i = j; i >= 0; i--){
                if(i == j) helper[i][j] = true;
                else{
                    helper[i][j] = (cs[i] == cs[j] &&( i+1 == j || helper[i+1][j-1]));
                }
            }
        }

        int[] count = new int[n];
        for(int i = 0; i < n; i++){
            if(helper[0][i]) count[i] = 0;
            else{
                count[i] = count[i-1];
                for(int j = i-2 ; j >= 0; j--){
                    if(count[i] > count[j] && helper[j+1][i]) count[i] = count[j];
                }
                count[i]++;
            }
        }
        return count[n-1];
    }
}