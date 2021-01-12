package leetCode._337_打家劫舍3;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;

public class test {
    public static void main(String[] args) {
        TreeNode a = ConstructTree.constructTree(new Integer[]{3,4,5,1,3,null,1});
        Solution s = new Solution();
        System.out.println(s.rob(a));
        System.out.println(s.rob1(a));
    }
}
