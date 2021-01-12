package leetCode_offer._34_二叉树中合为某一值的路径;

import leetCode.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return ans;
        caculate(root, sum, 0);
        return ans;
    }
    public void caculate(TreeNode root, int sum, int now){
        now = now + root.val;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(now == sum){
                ans.add(new LinkedList(list));
            }
            list.removeLast();
            return;
        }
        if(root.left != null){
            caculate(root.left, sum, now);
        }
        if(root.right != null){
            caculate(root.right, sum, now);
        }
        list.removeLast();
        return;
    }
}