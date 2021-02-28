package leetCode_offer._32_二叉树的层序遍历;

import leetCode.TreeNode.ConstructTree;
import leetCode.TreeNode.TreeNode;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        TreeNode temp = ConstructTree.constructTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(Arrays.toString(new Solution().levelOrder(temp)));

        List<List<Integer>> ans = new Solution1().levelOrder(temp);
        System.out.println(ans.toString());
    }
}
