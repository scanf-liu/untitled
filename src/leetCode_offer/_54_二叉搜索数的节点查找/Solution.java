package leetCode_offer._54_二叉搜索数的节点查找;

import leetCode.TreeNode.TreeNode;

public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int ans = -1;
    private int num = 0;

    public int kthLargest(TreeNode root, int k) {
        num = k;
        helper(root);
        return ans;
    }

    private void helper(TreeNode root) {
        if (num <= 0) return;
        if (root == null) return;
        helper(root.right);
        if (--num == 0) ans = root.val;
        helper(root.left);
    }
}