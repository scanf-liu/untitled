package leetCode.ListNode;

import java.util.ListIterator;

public class Construction {
    public static ListNode construct(int[] a){
        if (a.length == 0) return null;
        ListNode temp = new ListNode(a[a.length-1],null);
        for(int i = a.length-2; i >= 0; i--){
            temp = new ListNode(a[i],temp);
        }
        return temp;
    }

    public static void show(ListNode root){
        System.out.print("[");
        while( root != null){
            System.out.print(root.val);
            System.out.print(',');
            root = root.next;
        }
        System.out.println("]");
    }


    public static void main(String[] args) {
        ListNode root = construct(new int[]{1,3,4,5,6,7});
        show(root);
    }
}
