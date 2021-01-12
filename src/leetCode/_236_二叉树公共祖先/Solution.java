package leetCode._236_二叉树公共祖先;

import leetCode.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> p_helper = new ArrayList<>();
        //List<TreeNode> q_helper = new ArrayList<>();
        helper(root,p,p_helper);
        int size = p_helper.size();
        helper(root,q,p_helper);
        int i = size, j =0;
        while(true){
            if (i == p_helper.size()) i = 0;
            if (j == p_helper.size()) j = 0;

            if(p_helper.get(i).val ==p_helper.get(j).val) return p_helper.get(i);
            i++;
            j++;
        }
    }
    public static Boolean helper(TreeNode root, TreeNode p, List<TreeNode> helper){
        if(root == null) return false;
        if(root.val == p.val){
            helper.add(root);
            return true;
        }
        if(helper(root.right,p, helper) == true){
            helper.add(root);
            return true;
        }
        if(helper(root.left,p, helper) == true){
            helper.add(root);
            return true;
        }
        return false;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
