package leetCode_offer._27_二叉树的镜像;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;

public class test {
    public static void main(String[] args) {
        TreeNode a = ConstructTree.constructTree(new Integer[]{1, 2, 3, 4, 5, 4, 5});
        TreeOperation.show(a);
        TreeOperation.show(new Solution().mirrorTree(a));
    }
}
