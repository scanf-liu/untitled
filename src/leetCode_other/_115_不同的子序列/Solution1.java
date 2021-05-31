package leetCode_other._115_不同的子序列;

public class Solution1 {

    int ans;
    public int numDistinct(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        char[] tempArray = new char[t.length()];
        ans = 0;
        helper(sArray, tArray, tempArray, -1, -1);
        return ans;
    }


    public void helper(char[] sArray, char[] tArray, char[] tempArray, int sStart, int tempStart){
        if(!(tempStart == -1 || tArray[tempStart] == tempArray[tempStart] )) return;
        if(tempStart == tArray.length-1){
            ans++;
            return;
        }
        if(sStart == sArray.length - 1) return;
        tempStart++;
        for(int i = sStart+1; i < sArray.length; i++){
            tempArray[tempStart] = sArray[i];
            if(tArray[tempStart] == tempArray[tempStart]) helper(sArray, tArray, tempArray, i, tempStart);
        }
        return;
    }



}
