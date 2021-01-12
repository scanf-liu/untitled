package leetCode_offer._12_矩阵中的路径;

public class Solution {
    public boolean exist(char[][] board, String word) {
        //if(board.length == 0 && board[0].length == 0) return false;
        char[] helper = word.toCharArray();
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(judge(board, helper, i, j , 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean judge(char[][] board, char[] word, int i, int j, int index){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word[index]) return false;
        if(index == word.length - 1) return true;
        //char temp = board[i][j];
        board[i][j] = '.';
        boolean res = judge(board, word, i + 1, j, index + 1) || judge(board, word, i - 1, j, index + 1) ||
                judge(board, word, i, j + 1, index + 1) || judge(board, word, i, j - 1, index + 1);
        board[i][j] = word[index];
        return res;
    }

}