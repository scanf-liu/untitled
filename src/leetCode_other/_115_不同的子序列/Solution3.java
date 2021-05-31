package leetCode_other._115_不同的子序列;

public class Solution3 {

    public int numDistinct(String s, String t) {
        if(t.length() == 0) return 1;
        if(s.length() == 0) return 0;
        int[][] helper = new int[s.length()][t.length()];
        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == t.charAt(0)){
                if(i==0) helper[i][0] = 1;
                else helper[i][0] = helper[i-1][0] + 1;
            }else if(i != 0)  helper[i][0] = helper[i-1][0];
            for(int j = 1 ; j < t.length() && j <= i; j++){
                if(s.charAt(i) == t.charAt(j)) helper[i][j] += helper[i-1][j-1];
                helper[i][j] += helper[i-1][j];
            }
        }
        //System.out.println(Arrays.deepToString(helper));
        return helper[s.length()-1][t.length()-1];
    }
}