package leetCode_other._173_二叉树搜索迭代器;

import leetCode.TreeNode.TreeNode;

import java.util.LinkedList;

public class BSTIterator {
    //TreeNode head;
    LinkedList<TreeNode> helper;
    LinkedList<Boolean> flag;

    public BSTIterator(TreeNode root) {
        this.helper = new LinkedList<>();
        this.helper.addLast(root);
        while(root.left != null){
            root = root.left;
            helper.add(root);
        }
    }

    public int next() {
        TreeNode temp = helper.removeLast();
        int ans = temp.val;
        if(temp.right != null){
            temp = temp.right;
            helper.addLast(temp);
            while(temp.left != null){
                temp = temp.left;
                helper.add(temp);
            }
        }
        return ans;
    }

    public boolean hasNext() {
        if(this.helper.size() == 0 || helper.getLast() == null) return false;
        return true;
    }
}
