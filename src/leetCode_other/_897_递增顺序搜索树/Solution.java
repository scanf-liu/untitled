package leetCode_other._897_递增顺序搜索树;

import leetCode.TreeNode.TreeNode;

import java.util.LinkedList;

public class Solution {
    LinkedList<TreeNode> store = new LinkedList<>();
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        TreeNode r = new TreeNode();
        TreeNode pre = r;
        while(store.size() > 0){
            TreeNode temp = store.removeFirst();
            pre.right = temp;
            temp.left = null;
            pre = temp;
        }
        return r.right;
    }

    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        store.add(root);
        helper(root.right);
    }
}