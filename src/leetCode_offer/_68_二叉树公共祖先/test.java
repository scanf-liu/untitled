package leetCode_offer._68_二叉树公共祖先;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;

public class test {
    public static void main(String[] args) {
        TreeNode a = ConstructTree.constructTree(new Integer[]{6, 2, 111, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode b = a.left.left;
        TreeNode c = a.left.right.right;
        TreeOperation.show(a);
        System.out.println(new Solution().lowestCommonAncestor(a, b, c).val);
    }
}