package leetCode_offer._48_最长子字符串;

/*请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。*/

public class test {
    public static void main(String[] args) {
        String a = "sdaqeefg";
        System.out.println(new Solution().lengthOfLongestSubstring(a));
        System.out.println(new Solution1().lengthOfLongestSubstring(a));
        System.out.println(new Solution2().lengthOfLongestSubstring(a));
    }
}
