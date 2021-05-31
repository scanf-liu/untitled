package leetCode_other._12_整数转罗马数字;
/*12. 整数转罗马数字
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给你一个整数，将其转为罗马数字。*/
public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= 1000) num = helper(num, "M", 1000, sb);
        if(num >= 900) num = helper(num, "CM", 900, sb);
        if(num >= 500) num = helper(num, "D", 500, sb);
        if(num >= 400) num = helper(num, "CD", 400, sb);
        if(num >= 100) num = helper(num, "C", 100, sb);
        if(num >= 90) num = helper(num, "XC", 90, sb);
        if(num >= 50) num = helper(num, "L", 50, sb);
        if(num >= 40) num = helper(num, "XL", 40, sb);
        if(num >= 10) num = helper(num, "X", 10, sb);
        if(num >= 9) num = helper(num, "IX", 9, sb);
        if(num >= 5) num = helper(num, "V", 5, sb);
        if(num >= 4) num = helper(num, "IV", 4, sb);
        if(num >= 1) num = helper(num, "I", 1, sb);
        return sb.toString();
    }
    private int helper(int num, String big, int bigNum, StringBuilder sb){
        int temp = num/bigNum;
        for(int i = 0 ; i < temp; i++) sb.append(big);
        return num%bigNum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3999));
    }
}