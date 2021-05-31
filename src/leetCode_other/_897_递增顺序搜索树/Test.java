package leetCode_other._897_递增顺序搜索树;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;
import leetCode.TreeNode.TreeOperation;
/*给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。

 

示例 1：


输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/increasing-order-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Test {
    public static void main(String[] args) {
        TreeNode root = ConstructTree.constructTree(new Integer[]{5,3,6,2,4,null,8,1,null,null,null,7,9});
        TreeOperation.show(root);
        TreeOperation.show(new Solution().increasingBST(root));

        root = ConstructTree.constructTree(new Integer[]{5,3,6,2,4,null,8,1,null,null,null,7,9});
        TreeOperation.show(root);
        TreeOperation.show(new Solution1().increasingBST(root));
    }
}
