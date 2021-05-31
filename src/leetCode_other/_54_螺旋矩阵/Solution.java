package leetCode_other._54_螺旋矩阵;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int length = matrix[0].length;
        int height = matrix.length;
        boolean[][] helper = new boolean[height][length];
        int i = 0, j = 0, sub = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(matrix[0][0]);
        helper[0][0] = true;
        while(matrix[0].length - 2*sub > 0 && matrix.length - 2*sub > 0){
            if(j < matrix[0].length - sub){
                while(j < matrix[0].length - sub){
                    j++;
                    if(j < matrix[0].length - sub) {
                        if(helper[i][j]) return ans;
                        ans.add(matrix[i][j]);
                        helper[i][j] = true;
                        //System.out.println("1 "+matrix[i][j]);
                    }
                }
                j--;
            }else break;
            if(i < matrix.length - sub){
                while(i < matrix.length - sub){
                    i++;
                    if(i < matrix.length - sub) {
                        if(helper[i][j]) return ans;
                        ans.add(matrix[i][j]);
                        helper[i][j] = true;
                    }
                }
                i--;
            }else break;
            if(j >= sub){
                while(j >= sub){
                    j--;
                    if(j >= sub) {
                        if(helper[i][j]) return ans;
                        ans.add(matrix[i][j]);
                        helper[i][j] = true;
                    }
                }
                j++;
            }else break;
            sub++;
            if(i >= sub){
                while(i >= sub){
                    i--;
                    if(i >= sub){
                        if(helper[i][j]) return ans;
                        ans.add(matrix[i][j]);
                        helper[i][j] = true;
                    }
                }
                i++;
            }else break;
        }
        return ans;
    }
}