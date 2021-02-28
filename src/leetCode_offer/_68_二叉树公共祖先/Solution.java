package leetCode_offer._68_二叉树公共祖先;

import leetCode.TreeNode.TreeNode;

public class Solution {
    TreeNode node;

    //boolean flag = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return node;
    }

    public int find(TreeNode root, TreeNode p, TreeNode q) {
        //if(flag) return 0;
        if (root == null) return 0;
        int ans3 = find(root.right, p, q) | find(root.left, p, q);
        if (root == p) ans3 = ans3 | 1;
        if (root == q) ans3 = ans3 | 2;

        if (ans3 == 3) {
            node = root;
            //flag = true;
            return 0;
        }
        return ans3;
    }
}