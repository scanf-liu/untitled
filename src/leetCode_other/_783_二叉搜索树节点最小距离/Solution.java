package leetCode_other._783_二叉搜索树节点最小距离;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;

import java.util.ArrayList;
import java.util.List;
/*783. 二叉搜索树节点最小距离
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。*/
public class Solution {
    List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        helper(root);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            ans = Math.min(ans, list.get(i) - list.get(i-1));
            if(ans == 1) return ans;
        }
        return ans;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{1,0,48,null,null,12,49});
        TreeOperation.show(root);
        System.out.println();
        System.out.println(new Solution().minDiffInBST(root));
        System.out.println(new Solution().getMinimumDifference(root));
    }

    Integer pre = null;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper1(root);
        return ans;
    }
    public void helper1(TreeNode root){
        if(root == null || ans == 1) return;
        helper1(root.left);
        if(pre != null) ans = Math.min(ans, root.val - pre);
        pre = root.val;
        helper1(root.right);
    }






}