package leetCode_other._115_不同的子序列;

public class test {

    public static void main(String[] args) {

        String s = "bagbagbagbagbagb";
        String t = "bag";
        System.out.println(new Solution().numDistinct(s, t));
        System.out.println(new Solution1().numDistinct(s, t));
        System.out.println(new Solution3().numDistinct(s, t));
    }
}
