package leetCode_offer._55_平衡二叉树;

import leetCode.TreeNode.TreeNode;

public class Solution {
    private boolean ans = true;
    ;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return ans;
    }

    public int helper(TreeNode root) {
        if (!ans) return 0;
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) {
            ans = false;
            return 0;
        } else {
            return Math.max(right, left) + 1;
        }
    }
}