package leetCode._543_二叉树的直径;

import leetCode.TreeNode.TreeNode;

public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max-1;
    }
    public int helper(TreeNode root){
        if (root == null) return 0;
        int right = helper(root.right);
        int left = helper(root.left);
        max = Math.max(right+left+1, max);
        return Math.max(right, left)+1;
    }
}