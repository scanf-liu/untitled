package leetCode._477_汉明距离总和;
/*477. 汉明距离总和
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。

示例:

输入: 4, 14, 2

输出: 6

解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.*/
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int temp = 0;
            for(int num: nums){
                temp += ((num>>i)&1);
            }
            ans += (nums.length - temp) * temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {4,5,4,8,96,5,5,6,6,5,52};
        System.out.println(new Solution().totalHammingDistance(a));
    }
}