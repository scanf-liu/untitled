package leetCode_other._83_删除链表中的重复元素;

import leetCode.ListNode.Construction;
import leetCode.ListNode.ListNode;


public class test {
    public static void main(String[] args) {
        ListNode root = Construction.construct(new int[]{1,2,3,4,5,5,6,7,8,8,8});
        Construction.show(new Solution().deleteDuplicates(root));
    }
}
