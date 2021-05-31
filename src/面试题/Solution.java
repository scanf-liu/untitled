package 面试题;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String getStr(String command){
        if(command.length() == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = command.toCharArray();
        char before = chars[0];
        for(int i = 1; i < chars.length; i++){
            if((i & 1) == 1){
                for (int j = 0; j < chars[i]-'0'; j++) {
                    stringBuilder.append(before);
                }
            }else{
                before = chars[i];
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getStr("A0B3c0D4"));
    }
}
