package leetCode_offer._55_二叉树的深度;

import leetCode.TreeNode.*;

public class test {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{
                3, 9, 20, null, null, 15, 7});
        System.out.println(new Solution().maxDepth(root));
    }
}
