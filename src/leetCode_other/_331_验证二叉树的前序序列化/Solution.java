package leetCode_other._331_验证二叉树的前序序列化;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] helper = preorder.split(",");
        //if(helper.length == 1) return false;
        int index = helper.length-1;
        boolean flag = true;
        int sub = index - 2;
        while(flag){
            flag = false;
            if(index > 0&&helper[index].equals("#") &&helper[index-1].equals("#")){
                while(sub >= 0){
                    if(helper[sub].equals("#")) sub--;
                    else{
                        helper[sub] = "#";
                        index = index -2;
                        flag = true;
                        break;
                    }
                }
            }
        }
        return index == 0 && helper[0].equals("#");
    }
}