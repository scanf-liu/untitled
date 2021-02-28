package leetCode_offer._58_左旋字符串;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(n, s.length()));
        stringBuilder.append(s.substring(0, n));
        return stringBuilder.toString();
    }
}