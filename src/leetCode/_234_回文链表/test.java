package leetCode._234_回文链表;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;

public class test {
    public static void main(String[] args) {
        ListNode head  = Construction.construct(new int[]{1,2,2,1});
        System.out.println(Solution.isPalindrome1(head));
        System.out.println(Solution.isPalindrome(head));
    }
}
