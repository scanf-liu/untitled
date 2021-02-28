package leetCode_offer._19_正则表达式;

public class test {
    public static void main(String[] args) {
        String a = "aaaa.*", b = "aaaabb";
        System.out.println(new Solution().isMatch(b, a));
    }
}
