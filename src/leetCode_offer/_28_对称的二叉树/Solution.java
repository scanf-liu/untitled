package leetCode_offer._28_对称的二叉树;

import leetCode.TreeNode.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        //if(root.left == null && root.right == null) return true;
        //if(root.left == null || root.right == null) return false;
        return helper(root.right, root.left);
    }

    public boolean helper(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.val != B.val) return false;
        return helper(A.right, B.left) && helper(A.left, B.right);
    }
}