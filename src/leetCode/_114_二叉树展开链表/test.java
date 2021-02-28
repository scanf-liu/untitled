package leetCode._114_二叉树展开链表;
/*给定一个二叉树，原地将它展开为一个单链表。

         

        例如，给定二叉树

        1
        / \
        2   5
        / \   \
        3   4   6
        将其展开为：

        1
        \
        2
        \
        3
        \
        4
        \
        5
        \
        6

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import leetCode.TreeNode.*;


public class test {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        Solution.flatten(root);
        TreeOperation.show(root);
    }
}

class Solution {
    private static TreeNode pre = null;

    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
