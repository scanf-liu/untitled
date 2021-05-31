package leetCode_other._1914_二进制数转字符串;

public class Solution {
    public String printBin(double num) {

        if(num == 1) return "1";
        StringBuilder builder = new StringBuilder();
        builder.append("0.");
        for(int i=0; i < 32; i++){
            num *= 2;
            if(num < 1){
                //num -= 1;
                builder.append('0');
            }else{
                num -= 1;
                builder.append('1');
            }
            if(num == 0) break;
        }
        if(num == 0) return builder.toString();
        return "ERROR";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().printBin(0.3333));
        System.out.println(new Solution().printBin(0.625));
    }
}