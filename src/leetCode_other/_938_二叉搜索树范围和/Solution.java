package leetCode_other._938_二叉搜索树范围和;

import leetCode.TreeNode.*;

public class Solution {
    int ans = 0 ;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum( root, low, high);
        return ans;
    }

    public void sum(TreeNode root, int low, int high){
        if(root == null) return;
        if(root.val >= low) sum(root.left, low, high);
        if(root.val >= low && root.val <= high) ans += root.val;
        if(root.val <= high) sum(root.right, low, high);
    }

    public static void main(String[] args) {
        TreeNode treeNode = ConstructTree.constructTree(new Integer[]{10,5,15,3,7,null,18});
        TreeOperation.show(treeNode);
        System.out.println(new Solution().rangeSumBST(treeNode, 5, 10));
    }
}
