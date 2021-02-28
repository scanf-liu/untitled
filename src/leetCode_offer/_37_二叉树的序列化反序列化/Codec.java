package leetCode_offer._37_二叉树的序列化反序列化;

import leetCode.TreeNode.TreeNode;

import java.util.LinkedList;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        StringBuffer ans = new StringBuffer();
        while (list.size() != 0) {
            int length = list.size();
            TreeNode temp;
            for (int i = 0; i < length; i++) {
                temp = list.remove();
                if (temp != null) {
                    list.add(temp.left);
                    list.add(temp.right);
                    ans.append(temp.val);
                } else ans.append("null");
                ans.append(",");
            }
        }
        //System.out.println(ans.toString());
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] array = data.split(",");
        if (array.length == 0 || array[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        //System.out.print(array.length);
        for (int i = 1; i < array.length; i += 2) {
            if (list.size() == 0) break;
            TreeNode temp = list.remove();
            if (array[i].equals("null")) temp.left = null;
            else {
                TreeNode newNode = new TreeNode(Integer.parseInt(array[i]));
                list.add(newNode);
                temp.left = newNode;
            }
            if (array[i + 1].equals("null")) temp.right = null;
            else {
                TreeNode newNode = new TreeNode(Integer.parseInt(array[i + 1]));
                list.add(newNode);
                temp.right = newNode;
            }
        }
        return root;
    }
}