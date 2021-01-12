package leetCode._124_二叉树最大路径和;
import leetCode.TreeNode.*;

import java.net.Socket;

/*给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

 

示例 1：

输入：[1,2,3]

       1
      / \
     2   3

输出：6
示例 2：

输入：[-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出：42

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


public class test {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{-10,9,20,null,null,15,7});
        System.out.println(maxPathSum(root));
    }
    static int ans = 0;
    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        ans = root.val;
        helper(root);
        return ans;
    }
    public static int helper(TreeNode root){
        int now = 0;
        int left = 0, right = 0;
        if (root.left != null)  left = helper(root.left);
        if (root.right != null)  right = helper(root.right);
        ans = Math.max(ans, right+left+root.val);
        return Math.max(Math.max(right, left) + root.val, 0);
    }
}