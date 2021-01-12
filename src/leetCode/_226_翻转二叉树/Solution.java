package leetCode._226_翻转二叉树;

import leetCode.TreeNode.TreeNode;

public class Solution {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode helper = root.left;
        root.left = root.right;
        root.right = helper;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}