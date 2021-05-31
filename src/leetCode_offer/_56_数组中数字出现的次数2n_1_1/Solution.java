package leetCode_offer._56_数组中数字出现的次数2n_1_1;

/*首先，两个相同的数字的对应位都是相同的，所以一个被分到了某一组，另一个必然被分到这一组，所以满足了条件 2。

这个方法在 x_i = 1x
i
​
 =1 的时候 aa 和 bb 不被分在同一组，因为 x_i = 1x
i
​
 =1 表示 a_ia
i
​
  和 b_ib
i
​
  不等，根据这个方法的定义「如果该位为 00 就分到第一组，否则就分到第二组」可以知道它们被分进了两组，所以满足了条件 1。

在实际操作的过程中，我们拿到序列的异或和 xx 之后，对于这个「位」是可以任取的，只要它满足 x_i = 1x
i
​
 =1。但是为了方便，这里的代码选取的是「不为 00 的最低位」，当然你也可以选择其他不为 00 的位置。

至此，答案已经呼之欲出了。

算法
先对所有数字进行一次异或，得到两个出现一次的数字的异或值。

在异或结果中找到任意为 11 的位。

根据这一位对所有的数字进行分组。

在每个组内进行异或操作，得到两个数字。

作者：LeetCode-MyHashMap
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}