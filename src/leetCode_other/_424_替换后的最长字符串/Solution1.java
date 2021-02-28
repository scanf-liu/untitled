package leetCode_other._424_替换后的最长字符串;

public class Solution1 {
    public int characterReplacement(String s, int k) {
        int[][] helper = new int[26][s.length() + 1];
        int[][] ans = new int[26][2];
        int max = 0;
        for (int i = 0; i < 26; i++) helper[i][0] = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            for (int j = 0; j < 26; j++) {
                if (j != index) {
                    helper[j][++ans[j][1]] = i;
                    if (ans[j][1] - ans[j][0] > k) ans[j][0]++;
                }
                //System.out.println(j+"\t"+(i - helper[j][ans[j][0]]));
                max = Math.max(i - helper[j][ans[j][0]], max);
            }
        }
        return max;
    }
}