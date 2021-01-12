package leetCode_offer._27_二叉树的镜像;

import leetCode.TreeNode.TreeNode;

//利用返回值简化函数


public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
            if(root == null) return null;
            TreeNode tmp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
    }
}

