package leetCode._236_二叉树公共祖先;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;

public class test {
    public static void main(String[] args) {
        TreeNode node = ConstructTree.constructTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(Solution.lowestCommonAncestor1(node, new TreeNode(5), new TreeNode(1)).val);
        node = ConstructTree.constructTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(Solution.lowestCommonAncestor(node, new TreeNode(5), new TreeNode(1)).val);
    }
}
