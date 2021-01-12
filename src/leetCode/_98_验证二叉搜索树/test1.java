package leetCode._98_验证二叉搜索树;

public class test1 {
    static long pre = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node3 = new TreeNode(3,node6,null);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(test1.isValidBST(node1));
    }
}


