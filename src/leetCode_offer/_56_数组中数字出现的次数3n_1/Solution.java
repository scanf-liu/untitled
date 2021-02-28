package leetCode_offer._56_数组中数字出现的次数3n_1;


/*各二进制位的 位运算规则相同 ，因此只需考虑一位即可。如下图所示，对于所有数字中的某二进制位 11 的个数，存在 3 种状态，即对 3 余数为 0, 1, 20,1,2 。

设当前状态为 twotwo oneone ，此时输入二进制位 nn 。如下图所示，通过对状态表的情况拆分，可推出 oneone 的计算方法为：


if two == 0:
  if n == 0:
    one = one
  if n == 1:
    one = ~one
if two == 1:
    one = 0
引入 异或运算 ，可将以上拆分简化为：


if two == 0:
    one = one ^ n
if two == 1:
    one = 0
引入 与运算 ，可继续简化为：


one = one ^ n & ~two

*/

public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
