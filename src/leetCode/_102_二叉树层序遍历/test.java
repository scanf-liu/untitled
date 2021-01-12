package leetCode._102_二叉树层序遍历;

/*给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
    TreeNode node4 = new TreeNode(4,null,null);
    TreeNode node5 = new TreeNode(5,null,null);
    TreeNode node2 = new TreeNode(2,node4,node5);
    node4 = new TreeNode(5,null,null);
    node5 = new TreeNode(4,null,null);
    TreeNode node7 = new TreeNode(2,node4,node5);
    TreeNode node1 = new TreeNode(1,node2,node7);
    System.out.println(Solution.levelOrder(node1).toString());


    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> link = new LinkedList<TreeNode>();
        link.add(root);
        int size = 1;
        while(size > 0){
            List<Integer> list1 = new ArrayList<Integer>();
            for (int i = 0; i < size; i++){
                TreeNode now = link.removeFirst();
                list1.add(now.val);
                if(now.left != null) link.add(now.left);
                if(now.right != null) link.add(now.right);
            }
            list.add(list1);
            size = link.size();
        }
        return list;
    }
}