package leetCode._234_回文链表;

import leetCode.ListNode.ListNode;

public class Solution {
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = rev(slow);
        while(slow!= null){
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode rev(ListNode head){
        ListNode per = null;
        while(head != null){
            ListNode helper = head.next;
            head.next = per;
            per = head;
            head = helper;
        }
        return per;
    }
    static ListNode temp;

    public static boolean isPalindrome1(ListNode head) {
        temp = head;
        return check(head);
    }

    private static boolean check(ListNode head) {
        if (head == null)
            return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

}
