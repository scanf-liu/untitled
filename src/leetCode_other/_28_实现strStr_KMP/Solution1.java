package leetCode_other._28_实现strStr_KMP;

public class Solution1 {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        if(haystack.length() == needle.length()){
            if(haystack.equals(needle)) return 0;
            else return -1;
        }
        if(needle.length() == 0) return 0;

        int index = haystack.indexOf(needle.charAt(0));
        while(index > -1 && index <= haystack.length() - needle.length()){
            boolean flag = true;
            for(int i = 1 ; i < needle.length() ; i++){
                if(needle.charAt(i) != haystack.charAt(index + i)){
                    flag = false;
                    break;
                }
            }
            if(flag) return index;
            index = haystack.indexOf(needle.charAt(0), index + 1);
        }

        return -1;

    }

    public static void main(String[] args) {
        String s = "ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb";
        String s1 ="abbabbbabaa";
        System.out.println(new Solution1().strStr(s, s1));
    }
}