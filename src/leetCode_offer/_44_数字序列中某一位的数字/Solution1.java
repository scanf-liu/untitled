package leetCode_offer._44_数字序列中某一位的数字;

public class Solution1 {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int i = 1;
        int temp = 9;
        int temp_before = 0;
        while (temp < n) {
            temp_before = temp;
            temp += Math.pow(10, i) * 9 * (i + 1);
            i++;
        }

        n = n - temp_before;
        //System.out.println("n---"+n);
        //System.out.println("i---"+i);
        temp = (int) (((n - 1) / i) + Math.pow(10, i - 1));
        //System.out.println("temp---"+temp);
        //System.out.println(String.valueOf(temp).charAt((n-1)%i));
        return String.valueOf(temp).charAt((n - 1) % i) - '0';
    }
}