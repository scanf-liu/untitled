package leetCode_offer._32_二叉树的层序遍历;

import leetCode.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

         

        例如:
        给定二叉树: [3,9,20,null,null,15,7],

        3
        / \
        9  20
        /  \
        15   7
        返回：

        [3,9,20,15,7]*/

public class Solution {
    public int[] levelOrder(TreeNode root) {
        //if(root == null)  return new int[0]{};
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        list.add(root);
        while (list.size() != 0) {
            TreeNode temp = list.removeFirst();
            if (temp == null) continue;
            ans.add(temp.val);
            list.add(temp.left);
            list.add(temp.right);
        }
        int[] fin = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            fin[i] = ans.get(i);
        }
        return fin;
    }
}