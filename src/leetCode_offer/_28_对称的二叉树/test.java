package leetCode_offer._28_对称的二叉树;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;


//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//
//        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//            1
//           / \
//          2   2
//         / \ / \
//        3  4 4  3
//        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//            1
//           / \
//          2   2
//           \   \
//           3    3
//
//         
//
//        示例 1：
//
//        输入：root = [1,2,2,3,4,4,3]
//        输出：true
//        示例 2：
//
//        输入：root = [1,2,2,null,3,null,3]
//        输出：false



public class test {
    public static void main(String[] args) {
        TreeNode a = ConstructTree.constructTree(new Integer[]{1,2,2,3,4,4,3});
        TreeOperation.show(a);
        System.out.println(new Solution().isSymmetric(a));
        a = ConstructTree.constructTree(new Integer[]{1,2,2,null,3,null,3});
        TreeOperation.show(a);
        System.out.println(new Solution().isSymmetric(a));
    }
}
