package leetCode._437_路径总和;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;

public class test {
    public static void main(String[] args) {
        TreeNode a = ConstructTree.constructTree(new Integer[]{
                1, 2, 2, null, null, null, 0, null, -1, null, 1});
        System.out.println(new Solution().pathSum(a, 3));
    }
}
