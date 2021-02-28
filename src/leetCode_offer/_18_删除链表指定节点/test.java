package leetCode_offer._18_删除链表指定节点;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;

public class test {
    public static void main(String[] args) {
        ListNode a = Construction.construct(new int[]{2, 3, 4, 56, 8});
        Construction.show(a);
        Construction.show(new Solution().deleteNode(a, 56));
    }
}
