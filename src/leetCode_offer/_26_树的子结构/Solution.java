package leetCode_offer._26_树的子结构;

import leetCode.TreeNode.TreeNode;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        boolean ans = false;
        if(A.val == B.val){
            ans = helper(A, B);
        }
        return ans || isSubStructure(A.left, B) ||  isSubStructure(A.right, B);
    }
    public boolean helper(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return (A.val == B.val) && helper(A.left, B.left) && helper(A.right, B.right);
    }
}