package leetCode_offer._67_吧字符串数字转为整数;

public class Solution1 {
    public int strToInt(String str) {
        long ins = 0, flag = 1;
        int index = 0;

        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index == str.length()) return 0;
        if (str.charAt(index) == '+') {
            flag = 1;
            index++;
        } else if (str.charAt(index) == '-') {
            flag = -1;
            index++;
        }
        while (index < str.length() && str.charAt(index) <= '9' && str.charAt(index) >= '0') {
            ins = ins * 10 + str.charAt(index) - '0';
            index++;
            if (ins * flag > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (ins * flag < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        ins = ins * flag;
        if (ins > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ins < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) ins;

    }
}