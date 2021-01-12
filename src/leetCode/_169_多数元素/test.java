package leetCode._169_多数元素;

import java.util.Arrays;


/*给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


摩尔投票法思路
候选人(cand_num)初始化为nums[0]，票数count初始化为1。
当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
当票数count为0时，更换候选人，并将票数count重置为1。
遍历完数组后，cand_num即为最终答案。

为何这行得通呢？
投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。

无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。

作者：gfu
链接：https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

位运算
思路：由于众数数组中出现次数大于n/2 ，那么众数对应的二进制每一个为1的位数出现的次数一定大于n/2，由此可以得出众数

*/



public class test {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,1,1,1,1,1};
        System.out.println(Solution.majorityElement(a));
        System.out.println(Solution.majorityElement1(a));
        System.out.println(Solution.majorityElement2(a));
    }
}

class Solution {



    public static int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            if(candidate == nums[i]) count++;
            else if(--count == -1){
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return(nums[nums.length/2]);
    }

    public static int majorityElement2(int[] nums) {
        int result = 0, k = nums.length >> 1;
        for (int j = 0; j < 32; j++) {
            int count = 0;
            for (int num : nums) {
                count += num >> j & 1;
                if (count > k) {
                    result += 1 << j;
                    break;
                }
            }
        }
        return result;
    }

}