package leetCode_offer._50_第一个只出现一次的字符;

/*剑指 Offer 50. 第一个只出现一次的字符
        在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

        示例:

        s = "abaccdeff"
        返回 "b"

        s = ""
        返回 " "*/

public class test {
    public static void main(String[] args) {
        String s = "rerwrwdwefwq";
        System.out.println(new Solution().firstUniqChar(s));
        System.out.println(new Solution1().firstUniqChar(s));
    }
}
