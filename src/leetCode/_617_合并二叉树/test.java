package leetCode._617_合并二叉树;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;

public class test {
    public static void main(String[] args) {
        TreeNode t1 = ConstructTree.constructTree(new Integer[]{1, 3, 2, 5});
        TreeNode t2 = ConstructTree.constructTree(new Integer[]{2, 1, 3, null, 4, null, 7});
        TreeOperation.show(t1);
        TreeOperation.show(t2);
        t1 = new Solution().mergeTrees(t1, t2);
        TreeOperation.show(t1);
    }
}
