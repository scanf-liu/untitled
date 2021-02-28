package leetCode._297_二叉树序列化反序列化;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;

public class test {
    public static void main(String[] args) {
        TreeNode node = ConstructTree.constructTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeOperation.show(node);
        String a = CodeC.serialize(node);
        System.out.println(a);
        TreeNode nod1 = CodeC.deserialize(a);
        TreeOperation.show(nod1);
    }
}
