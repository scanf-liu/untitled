package leetCode_offer._24_链表反转;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;

public class test {
    public static void main(String[] args) {
        ListNode a = Construction.construct(new int[]{1, 2, 4, 5, 6, 7, 4, 8});
        Construction.show(new Solution().reverseList(a));
        a = Construction.construct(new int[]{1, 2, 4, 5, 6, 7, 4, 8});
        Construction.show(new Solution1().reverseList(a));

    }
}
