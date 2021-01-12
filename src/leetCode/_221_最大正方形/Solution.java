package leetCode._221_最大正方形;

public class Solution {
    public static int maximalSquare(char[][] matrix) {
        int ans = -1;

        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[0].length ; j++){
                if(matrix[i][j] == '0') continue;

                int plus = ans + 1;
                boolean flag = true;

                if(j+plus >= matrix[0].length) continue;
                if(i+plus >= matrix.length) continue;

                for (int a = i; a <= i + plus ; a++){
                    for(int b = j; b <= j + plus ; b++){
                        if (matrix[a][b] == '0'){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                }
                if(!flag) continue;

                while(true){
                    ans = plus;
                    plus++;
                    if(j+plus >= matrix[0].length) break;
                    if(i+plus >= matrix.length) break;
                    for(int a = 0 ; a <= plus ; a++){
                        if (matrix[i+plus][j+a] == '0' || matrix[i+a][j+plus] == '0'){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                    System.out.println(plus);
                }
            }
        }
        return (ans+1) * (ans+1);
    }

    public static int maximalSquare1(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
        int[][] dp = new int[height + 1][width + 1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
