package leetCode_other._83_删除链表中的重复元素;

import leetCode.ListNode.ListNode;
/*83. 删除排序链表中的重复元素
存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

返回同样按升序排列的结果链表。*/
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(-1,head);
        ListNode nodeBefore = head;
        if(head == null) return null;
        ListNode nodeAfter = head.next;

        while(nodeAfter != null){
            if(nodeBefore.val == nodeAfter.val){
                nodeAfter = nodeAfter.next;
            }else{
                nodeBefore.next = nodeAfter;
                nodeBefore = nodeAfter;
                nodeAfter = nodeAfter.next;
            }
        }
        nodeBefore.next = null;
        return helper.next;
    }
}