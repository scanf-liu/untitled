package leetCode._48_旋转图像;

/*给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:

给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/



public class test {
    public static void main(String[] args) {
        int[][] m ={{1,2,6},{1,2,9},{1,2,9}};
        Solution.rotate(m);
        for (int i = 0; i<m.length; i++){
            for (int j = 0; j < m.length; j ++)
                System.out.print(m[i][j]);
            System.out.println("");
        }
        //System.out.println(m);
    }
}


class Solution {
    public static void rotate(int[][] matrix) {
        int add = 0;
        int temp = 0;
        int pos1 = 0;
        int pos2 = matrix[0].length - 1;
        while (pos1 < pos2){
            add = 0;
            while (add < pos2 - pos1){
                temp = matrix[pos1][pos1 + add];
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 -add];
                matrix[pos2][pos2 -add] = matrix[pos1 + add][pos2];
                matrix[pos1 + add][pos2] = temp;
                add++;
            }
            pos1++;
            pos2--;


        }
    }
}