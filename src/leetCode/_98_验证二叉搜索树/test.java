package leetCode._98_验证二叉搜索树;

public class test {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node3 = new TreeNode(3,node6,null);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println(Solution.isValidBST(node1));
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return judge(root, -2147483648, 2147483647, false, false);
    }
    public static boolean judge(TreeNode root, int min, int max, boolean flag_min, boolean flag_max){

        if (min >= root.val && flag_min ) return false;
        if (flag_max && max <= root.val) return false;

        boolean judge_l = true, judge_2 = true;
        if (root.left != null){
            judge_l = judge(root.left, min, root.val, flag_min, true);
        }
        if (root.right != null){
            judge_2 = judge(root.right, root.val, max,true, flag_max);
        }
        return judge_l && judge_2;
    }


}