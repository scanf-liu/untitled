package leetCode_other._1734_解码异或后的排列;

/*给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。

它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。

给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。

 

示例 1：

输入：encoded = [3,1]
输出：[1,2,3]
解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
示例 2：

输入：encoded = [6,5,4,6]
输出：[2,4,1,5,3]
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-xored-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.Arrays;

public class Solution {
    public int[] decode(int[] encoded) {
        int length = encoded.length + 1;
        //把1到n中间的所有数字都异或一遍
        int allXor = ((length + 1) / 2) % 2;
        int even = 0;
        //数组encoded中第偶数个元素都异或一遍
        for (int i = 1; i < length - 1; i += 2) {
            even ^= encoded[i];
        }

        int[] res = new int[length];
        //求出第一个值，后面就简单了
        res[0] = allXor ^ even;
        for (int i = 0; i < length - 1; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decode(new int[]{6, 5, 4, 6})));
    }
}