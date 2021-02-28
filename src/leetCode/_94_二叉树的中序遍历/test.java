package leetCode._94_二叉树的中序遍历;

/*给定一个二叉树，返回它的中序 遍历。
 *
 *
 * */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(Solution.inorderTraversal(node1).toString());
        System.out.println(Solution.inorderTraversal_stack(node1).toString());
        System.out.println(Solution.inorderTraversal_Morris(node1).toString());
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    //递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root != null) middle(ans, root);
        return ans;
    }

    public static void middle(List<Integer> ans, TreeNode root) {
        if (root.left != null) middle(ans, root.left);
        ans.add(root.val);
        if (root.right != null) middle(ans, root.right);
    }

    //迭代
    public static List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                TreeNode now = stack.pop();
                ans.add(now.val);
                root = now.right;
            }
        }

        return ans;
    }

    //Morris 改变树的结构
    public static List<Integer> inorderTraversal_Morris(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode pre = null;
        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root;
                TreeNode tmp = root;
                root = root.left;
                tmp.left = null;
            } else {
                ans.add(root.val);
                root = root.right;
            }
        }

        return ans;
    }

}