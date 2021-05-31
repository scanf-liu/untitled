package leetCode_other._173_二叉树搜索迭代器;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;

public class test {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator obj = new BSTIterator(root);
        while(obj.hasNext()){
            System.out.println(obj.next());
        }

    }
}
