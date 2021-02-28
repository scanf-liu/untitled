package leetCode._101_对称二叉树;

import java.util.LinkedList;



/*给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


public class test {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        node4 = new TreeNode(5, null, null);
        node5 = new TreeNode(4, null, null);
        TreeNode node7 = new TreeNode(2, node4, node5);

        TreeNode node1 = new TreeNode(1, node2, node7);
        System.out.println(Solution.isSymmetric(node1));
        System.out.println(Solution.isSymmetric1(node1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judge(root.left, root.right);
    }

    public static boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return judge(left.left, right.right) && judge(left.right, right.left);
    }

    public static boolean isSymmetric1(TreeNode root) {

        if (root == null) return true;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root.left);
        list.add(root.right);
        while (list.size() > 0) {
            TreeNode left = list.removeFirst();
            TreeNode right = list.removeFirst();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            list.add(left.left);
            list.add(right.right);
            list.add(left.right);
            list.add(right.left);
        }
        return true;
    }
}