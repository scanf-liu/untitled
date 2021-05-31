package leetCode_other._28_实现strStr_KMP;

import java.util.Arrays;

public class KMP {
    public int KMP(String longS, String shortS){
        if(longS.length() == 0) return 0;

        char[] lc = (" "+longS).toCharArray();
        char[] sc = (" "+shortS).toCharArray();

        int[] next = new int[sc.length];
        for (int i = 2, j = 0; i < sc.length; i++) {
            while(j > 0 && sc[j+1] != sc[i]) j = next[j];
            if(sc[j+1] == sc[i]) j++;
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));

        for(int i = 1, j = 0; i <= longS.length(); i++){
            while (j > 0 && sc[j+1] != lc[i]) j = next[j];
            if(sc[j+1] == lc[i]) j++;
            if(shortS.length() == j) return i - j;
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb";
        String s1 ="abbabbbabaa";
        System.out.println(new KMP().KMP(s, s1));
        System.out.println(new Solution1().strStr(s, s1));
        System.out.println(new Solution().strStr(s, s1));
    }
}
