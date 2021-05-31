package leetCode_other._633_平方数之和;
/*给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。*/
public class Solution {
    /*翻译过来就是：当且仅当一个自然数的质因数分解中，
    满足 4k+3 形式的质数次方数均为偶数时，该自然数才能被表示为两个平方数之和。*/
    public boolean judgeSquareSum1(int c) {
        for (int i = 2, cnt = 0; i * i <= c; i++, cnt = 0) {
            while (c % i == 0 && ++cnt > 0) c /= i;
            if (i % 4 == 3 && cnt % 2 != 0) return false;
        }
        return c % 4 != 3;
    }

    public boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c/2);
        for (int a = 0; a <= max; a++) {
            int b = (int)Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }

    //双指针
    public boolean judgeSquareSum2(int c) {
        int a = 0, b = (int)Math.sqrt(c);
        while (a <= b) {
            int cur = a * a + b * b;
            if (cur == c) {
                return true;
            } else if (cur > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeSquareSum(22222222));
        System.out.println(solution.judgeSquareSum2(22222222));
        System.out.println(solution.judgeSquareSum1(22222222));

    }

}
