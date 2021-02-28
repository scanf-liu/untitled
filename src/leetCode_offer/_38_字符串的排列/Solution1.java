package leetCode_offer._38_字符串的排列;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    Set<String> ans = new HashSet<>();

    public String[] permutation(String s) {
        helper(s, new int[s.length()], new StringBuilder());
        String[] array2 = new String[ans.size()];
        ans.toArray(array2);
        return array2;
    }

    public void helper(String s, int[] helper, StringBuilder temp) {
        if (temp.length() == helper.length) {
            ans.add(temp.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (helper[i] == 1) continue;
            helper[i] = 1;
            helper(s, helper, new StringBuilder(temp).append(s.charAt(i)));
            helper[i] = 0;
        }
        return;
    }
}