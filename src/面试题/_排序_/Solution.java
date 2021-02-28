package 面试题._排序_;

/*输入：随机字符串，包含英文数字字符
  输出：字符串中的重复字符，数字从小到大排序，重复数字不合并
  输入："j1fkjf,134650"
  输出："0113456"
* */

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().helper("0,00"));
        System.out.println(new Solution().helper("0,0210"));
        System.out.println(new Solution().helper("j1fkjf,134650"));
        System.out.println(new Solution().helper(""));
    }

    public String helper(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count[s.charAt(i) - '0']++;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            while (count[i] >= 1) {
                ans.append(i);
                count[i]--;
            }
        }
        System.out.println("helper");
        return ans.toString();
    }
}
