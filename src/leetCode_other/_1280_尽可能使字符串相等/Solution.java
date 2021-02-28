package leetCode_other._1280_尽可能使字符串相等;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int m = s.length();
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = Math.abs(sch[i] - tch[i]);
        }

        int maxLegth = 0;
        int sum = 0;
        for (int left = 0, right = 0; right < result.length; right++) {
            sum += result[right];
            if (sum <= maxCost) { //右指针在走
                maxLegth = Math.max(maxLegth, right - left + 1);
            } else { //走左指针
                sum -= result[left];
                left++;
            }
        }
        return maxLegth;
    }
}