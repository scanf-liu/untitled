package leetCode._297_二叉树序列化反序列化;

import leetCode.TreeNode.TreeNode;

import java.util.LinkedList;

public class CodeC {
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuffer a = new StringBuffer();
        LinkedList<TreeNode> helper = new LinkedList<TreeNode>();
        helper.addLast(root);
        while(helper.size() > 0){
            TreeNode now = helper.poll();
            if(now == null){
                a.append("n,") ;
                continue;
            }
            else{
                a.append(now.val) ;
                a.append(",") ;
                helper.addLast(now.left);
                helper.addLast(now.right);
            }
        }
        //System.out.println(a);
        return a.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        LinkedList<TreeNode> helper = new LinkedList<TreeNode>();
        LinkedList<TreeNode> helper1 = new LinkedList<TreeNode>();
        String a = "";

        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == ','){
                TreeNode now = new TreeNode();
                if(!a.equals("n")){
                    now.val = Integer.parseInt(a);
                }else now = null;
                helper.addLast(now);
                a = "";
            }else{
                a += data.charAt(i);
            }

        }
        TreeNode root = helper.poll();
        if(root == null) return root;

        helper1.addLast(root);

        while(helper.size() > 0){
            TreeNode now = helper1.poll();

            now.left =  helper.poll();
            if(now.left != null) helper1.addLast(now.left);
            now.right =  helper.poll();
            if(now.right != null) helper1.addLast(now.right);

        }
        return root;
    }
}
