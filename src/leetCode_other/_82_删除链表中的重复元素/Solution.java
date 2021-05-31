package leetCode_other._82_删除链表中的重复元素;

import leetCode.ListNode.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode helper = new ListNode(-1, head);
        ListNode tail = helper;
        ListNode before = head;
        ListNode temp = head.next;
        boolean flag = false;
        while(temp != null){
            if(before.val == temp.val){
                temp = temp.next;
                flag = true;
            }else{
                if(flag){
                    tail.next = temp;
                    before = temp;
                    temp = temp.next;
                }
                else{
                    tail = tail.next;
                    before = before.next;
                    temp = temp.next;
                }
                flag = false;
            }
        }
        if(flag) tail.next = null;
        return helper.next;

    }
}