package leetCode._206_反转链表;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;
import org.w3c.dom.ls.LSException;



/*
反转链表
*/

public class Solution {

    public static void main(String[] args) {
        ListNode a = Construction.construct(new int[]{1,2,4,5,7,8,9});
        a = reverseList1(a);
        Construction.show(a);
        a = reverseList(a);
        Construction.show(a);

    }

    //递归
    static ListNode per = null;
    public static ListNode reverseList(ListNode head) {
        if(head == null) return per;
        ListNode next = head.next;
        head.next = per;
        per = head;
        return reverseList(next);
    }
    //迭代
    public static ListNode reverseList1(ListNode head) {
        ListNode per = null;
        while(head != null){
            ListNode next = head.next;
            head.next = per;
            per = head;
            head = next;
        }
        return per;
    }



}