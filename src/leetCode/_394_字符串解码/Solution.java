package leetCode._394_字符串解码;

import java.util.LinkedList;

public class Solution {
    public String decodeString(String s) {
        LinkedList<StringBuffer> helper = new LinkedList<>();
        LinkedList<Integer> num = new LinkedList<>();
        StringBuffer a = new StringBuffer();
        StringBuffer num1 = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now <= '9' && now >= '0') {
                num1.append(now);
                if (a.length() == 0) continue;
                helper.add(a);
                a = new StringBuffer();
            } else if (now == '[') {
                num.add(Integer.parseInt(num1.toString()));
                helper.add(new StringBuffer());
                num1 = new StringBuffer();
            } else if (now == ']') {
                int times = num.removeLast();
                StringBuffer temp = new StringBuffer();
                StringBuffer temp1 = a;
                for (int j = 0; j < times; j++) {
                    temp.append(temp1);
                }
                helper.removeLast();
                while (helper.size() != 0 && helper.getLast().length() != 0) {
                    temp = helper.removeLast().append(temp);
                }

                a = temp;
            } else {
                a.append(now);
            }
        }
        return a.toString();
    }
}