package leetCode_other._424_替换后的最长字符串;


/*滑动窗口*/

public class Solution {
    public int characterReplacement(String s, int k) {
        int[] record = new int[26];
        int len = s.length();
        char[] arr = s.toCharArray();
        int left = 0;
        int right = 0;
        int historyMax = 0;
        while (right < len) {
            record[arr[right] - 'A']++;
            historyMax = Math.max(historyMax, record[arr[right] - 'A']);
            right++;
            while (right - left > historyMax + k) {
                record[arr[left] - 'A']--;
                left++;
            }
        }
        return right - left;
    }
}