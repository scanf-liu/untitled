package leetCode_offer._06_从头到尾打印链表;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        ListNode a = Construction.construct(new int[]{12, 3, 4, 5, 6, 7, 8});
        Construction.show(a);
        System.out.println(Arrays.toString(new Solution().reversePrint(a)));
        System.out.println(Arrays.toString(new Solution1().reversePrint(a)));
    }
}
