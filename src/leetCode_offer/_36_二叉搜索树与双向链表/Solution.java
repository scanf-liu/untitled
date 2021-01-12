package leetCode_offer._36_二叉搜索树与双向链表;

public class Solution {
    Node temp;
    Node head;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        helper(root);
        head.left = temp;
        temp.right = head;
        return head;
    }
    public void helper(Node root){
        if(root == null) return;
        helper(root.left);
        if(head == null){
            head = root;
            temp = head;
        }else{
            temp.right = root;
            root.left = temp;
            temp = root;
        }
        helper(root.right);
        return;
    }
}