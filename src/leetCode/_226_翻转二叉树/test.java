package leetCode._226_翻转二叉树;

import leetCode.TreeNode.*;

public class test {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{3, 4, 5, 1, 2, 3, 6});
        TreeOperation.show(root);
        TreeOperation.show(Solution.invertTree(root));
    }
}
