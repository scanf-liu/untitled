package leetCode_offer._54_二叉搜索数的节点查找;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;

/*剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。



示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4*/
public class test {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{3, 1, 4, null, 2});
        System.out.println(new Solution().kthLargest(root, 2));
    }
}
