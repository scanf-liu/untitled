package leetCode_other._61_旋转链表;

import leetCode.ListNode.ListNode;
/*给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next == null||k == 0) return head;
        ListNode node = head, tail = null;
        int num = 0;
        while(node != null){
            tail = node;
            node = node.next;
            num++;
        }
        node = head;
        for(int i = 0 ; i <= k%num; i++){
            node = node.next;
        }
        ListNode node1 = node.next;
        node.next = null;
        tail.next = head;
        return node1;
    }
}