package leetCode._104_二叉树的最大深度;

public class test {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        node4 = new TreeNode(5, null, null);
        node5 = new TreeNode(4, null, null);
        TreeNode node7 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node7);

        System.out.println(Solution.maxDepth(node1));
    }
}

class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}


class Solution {
    public static int maxDepth(TreeNode root) {
        return max_sp(root, 0, 0);
    }

    public static int max_sp(TreeNode root, int ans, int now) {
        if (root == null) {
            return Math.max(ans, now);
        }
        return Math.max(Math.max(max_sp(root.left, ans, now + 1), max_sp(root.right, ans, now + 1)), ans);
    }
}