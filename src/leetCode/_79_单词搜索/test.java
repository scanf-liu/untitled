package leetCode._79_单词搜索;


/*给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class test {
    public static void main(String[] args) {
        char[][] board = {{'a','b','a','b'},{'a','d','a','b'},{'a','b','a','b'}};
        System.out.println(Solution.exist(board, "abda"));
    }
}


class Solution {
    public static boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    if ( dfs(board,word.toCharArray(), i, j, 0) == true) return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        //然后修改当前坐标的值
        board[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }
}
