package leetCode._128_最长连续序列;

/*给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

 

进阶：

你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 

示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        System.out.println(Solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}

class Solution {
    public static int longestConsecutive(int[] nums) {
        Set<Long> set = new HashSet<Long>();
        for(int i = 0; i< nums.length; i++){
            set.add((long)nums[i]);
        }
        int ans = 0;

        for(long val : set){
            if(set.contains(val-1)) continue;
            long now = val;
            int ans_now = 1;

            while(set.contains(now + 1)){
                now = now + 1;
                ans_now = ans_now + 1;
            }

            if (ans < ans_now) ans = ans_now;

        }

        return ans;
    }
}


