package leetCode_other._897_递增顺序搜索树;

import leetCode.TreeNode.TreeNode;

public class Solution1 {
    TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode h = new TreeNode();
        pre = h;
        helper(root);
        return h.right;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        pre.right = root;
        root.left = null;
        pre = root;
        helper(root.right);
    }


}
