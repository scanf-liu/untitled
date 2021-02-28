package leetCode_offer._22_链表中倒数第k个节点;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;

public class test {
    public static void main(String[] args) {
        ListNode a = Construction.construct(new int[]{1, 2, 4, 5, 6, 7, 4, 8});
        Construction.show(new Solution().getKthFromEnd(a, 3));
        Construction.show(new Solution1().getKthFromEnd(a, 3));
    }
}
