package leetCode_other._2052_阶乘尾数;
/*设计一个算法，算出 n 阶乘有多少个尾随零。

示例 1:

输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。
示例 2:

输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution {
    public int trailingZeroes(int n) {
        long helper = 5;
        int ans = 0;
        while(n >= helper){
            ans += n/helper;
            helper *= 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(45454));
    }
}