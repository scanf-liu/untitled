package leetCode_other._993_二叉树的兄弟节点;

import leetCode.TreeNode.*;
/*993. 二叉树的堂兄弟节点
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。

 */
public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] x_array = fps(root, new TreeNode(-1), x, 0);
        int[] y_array = fps(root, new TreeNode(-1), y, 0);
        if(x_array[0] != y_array[0] && x_array[1] == y_array[1]) return true;
        else return false;
    }

    public int[] fps(TreeNode root, TreeNode father, int x, int depth){
        if(root == null) return null;
        if(root.val == x) return new int[]{father.val, depth};
        depth++;

        int[] ans = fps(root.left, root, x, depth);
        if(ans != null) return ans;

        ans = fps(root.right, root, x, depth);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode = ConstructTree.constructTree(new Integer[]{1, 2, 3, null, 4, null, 5});
        System.out.println(new Solution().isCousins(treeNode, 4, 5));
    }
}