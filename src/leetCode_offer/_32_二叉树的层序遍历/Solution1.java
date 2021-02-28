package leetCode_offer._32_二叉树的层序遍历;

import leetCode.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

         

        例如:
        给定二叉树: [3,9,20,null,null,15,7],

        3
        / \
        9  20
        /  \
        15   7
        返回其层次遍历结果：

        [
        [3],
        [20,9],
        [15,7]
        ]*/

public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<TreeNode> helper = new LinkedList<>();
        if (root == null) return ans;
        helper.add(root);
        int flag = 0;
        while (helper.size() != 0) {
            int size = helper.size();
            LinkedList<Integer> ans1 = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = helper.removeLast();
                if (temp.left != null) helper.addFirst(temp.left);
                if (temp.right != null) helper.addFirst(temp.right);
                if ((flag & 1) == 0) ans1.add(temp.val);
                else ans1.addFirst(temp.val);
            }
            ans.add(ans1);
            flag++;
        }
        return ans;
    }
}