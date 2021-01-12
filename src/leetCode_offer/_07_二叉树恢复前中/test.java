package leetCode_offer._07_二叉树恢复前中;

import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;

public class test {
    public static void main(String[] args) {
        TreeNode a = new Solution().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        TreeOperation.show(a);
    }
}
