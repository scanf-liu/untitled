package leetCode_offer._46_把数字翻译成字符串;

public class Solution2 {
    int translateNum(int num) {
        if (num == 0) return 1;
        return f(num);
    }

    int f(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return f(num / 10) + f(num / 100);
        } else {
            return f(num / 10);
        }
    }
}
