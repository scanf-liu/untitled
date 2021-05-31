package leetCode._42_接雨水;

import java.util.Stack;

/*定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


public class test {
    public static void main(String[] args) {
        int[] h = new int[]{1, 4, 9, 8, 9};
        System.out.println(Solution.trap(h));
    }
}


class Solution {
    public static int trap(int[] height) {
        if (height == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[cur]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int top = stack.peek();
                    ans += (Math.min(height[top], height[i]) - height[cur]) * (i - top - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
