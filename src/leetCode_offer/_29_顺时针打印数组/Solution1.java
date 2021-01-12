package leetCode_offer._29_顺时针打印数组;

public class Solution1 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int[] ans = new int[matrix.length* matrix[0].length];
        helper(ans, 0, matrix, 0, 0, matrix.length, matrix[0].length);
        return ans;
    }
    private void helper(int[] ans, int index, int[][] matrix, int height, int length, int height1, int length1){
        if(height1 <= 0 || length1 <=0 ) return;
        for(int i = 0; i < length1; i++){
            ans[index++] = matrix[height][i+length];
        }
        for(int i = 1; i < height1-1; i++){
            ans[index++] = matrix[height+i][length1+length-1];
        }
        if(height1 != 1){
            for(int i = length1 - 1; i >= 0; i--){
                ans[index++] = matrix[height+height1-1][i+length];
            }
        }
        if(length1 != 1){
            for(int i = height1 - 2; i >= 1; i--){
                ans[index++] = matrix[height+i][length];
            }
        }
        helper(ans, index, matrix, height+1, length+1, height1-2, length1-2);
        //return;
    }

}