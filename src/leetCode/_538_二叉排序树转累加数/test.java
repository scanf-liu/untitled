package leetCode._538_二叉排序树转累加数;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;

public class test {
    public static void main(String[] args) {
        TreeNode a = ConstructTree.constructTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        TreeOperation.show(a);
        a = new Solution().convertBST(a);
        TreeOperation.show(a);

    }
}
