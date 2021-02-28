package leetCode._337_打家劫舍3;

import leetCode.TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

    Map<TreeNode, Integer> helper = new HashMap<>();

    public int rob1(TreeNode root) {
        if (root == null) return 0;

        if (helper.containsKey(root)) return helper.get(root);
        int left = 0, right = 0;
        if (root.left != null) left = rob(root.left.left) + rob(root.left.right);
        if (root.right != null) right = rob(root.right.left) + rob(root.right.right);

        int ans = Math.max(rob(root.left) + rob(root.right), root.val + left + right);
        helper.put(root, ans);

        return ans;

    }

}
