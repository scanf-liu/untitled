package leetCode_offer._20_判断数字是否合法;

public class Solution {
    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        int flag_point = -1;
        int flag_e = -1;
        int length = s.length();
        int start = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length = i + 1;
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        for (int i = start; i < length; i++) {
            if (s.charAt(i) == '.') {
                if (flag_point == -1) flag_point = i;
                else return false;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (flag_e == -1) flag_e = i;
                else return false;
            } else if ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '+' || s.charAt(i) == '-') continue;
            else return false;
        }

        if (flag_e == length - 1) return false;
        if (flag_e == -1) {
            if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                return judege_small(start + 1, length, s);
            } else return judege_small(start, length, s);
        } else {
            if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                if (!judege_small(start + 1, flag_e, s)) return false;
            } else {
                if (!judege_small(start, flag_e, s)) return false;
            }
            if (s.charAt(flag_e + 1) == '+' || s.charAt(flag_e + 1) == '-') {
                return judege_integer(flag_e + 2, length, s);
            } else {
                return judege_integer(flag_e + 1, length, s);
            }
        }
    }

    private boolean judege_small(int start, int end, String s) {
        if (start >= end) return false;
        if (end - start == 1 && s.charAt(start) == '.') return false;
        //if(s.charAt(end - 1) == '.') return false;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') return false;
        }
        return true;
    }

    private boolean judege_integer(int start, int end, String s) {
        if (start >= end) return false;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '.') return false;
        }
        return true;
    }
}