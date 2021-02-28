package leetCode_offer._25_合并两个排序链表;

import leetCode.ListNode.Construction;

public class test {
    public static void main(String[] args) {
        Construction.show(new Solution().mergeTwoLists(
                Construction.construct(new int[]{1, 2, 5, 7, 89}),
                Construction.construct(new int[]{1, 8, 66, 99})));
    }
}
