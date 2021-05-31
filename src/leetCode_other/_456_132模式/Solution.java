package leetCode_other._456_132模式;

import java.util.ArrayDeque;
import java.util.Deque;
/*这样做的本质是：我们通过维护「单调递减」来确保已经找到了有效的 (j,k)。换句话说如果 k 有值的话，那么必然是因为有 j > k，导致的有值。也就是 132 结构中，我们找到了 32，剩下的 i （也就是 132 结构中的 1）则是通过遍历过程中与 k 的比较来找到。这样做的复杂度是 O(n)O(n) 的，比树状数组还要快。

作者：AC_OIer
链接：https://leetcode-cn.com/problems/132-pattern/solution/xiang-xin-ke-xue-xi-lie-xiang-jie-wei-he-95gt/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                // 事实上，k 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}