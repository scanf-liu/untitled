package leetCode_other._363_矩形区域不超过K的最大数值和;

class Solution1 {
    public int maxSumSubmatrix(int[][] matrix, int kk) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 1 ; j < matrix[0].length; j++){
                if(matrix[i][j] == kk) return kk;
                if(matrix[i][j] < kk) ans = Math.max(matrix[i][j], ans);
                matrix[i][j] += matrix[i][j-1];
                if(matrix[i][j] == kk) return kk;
                if(matrix[i][j] < kk) ans = Math.max(matrix[i][j], ans);
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                matrix[i][j] += matrix[i-1][j];

                if(matrix[i][j] == kk) return kk;
                if(matrix[i][j] < kk) ans = Math.max(matrix[i][j], ans);

            }
        }


        for(int i = 0; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(i == 0 && j == 0) continue;
                for(int k = i; k < matrix.length; k++){
                    for(int w = j ; w < matrix[0].length; w++){
                        int temp = cal(matrix, i, j, k, w);
                        if(temp == kk) return temp;
                        if(temp < kk){
                            ans = Math.max(temp, ans);
                        }
                    }
                }

            }
        }
        return ans;
    }

    public int cal(int[][] matrix, int i, int j, int k, int w){
        int ans = matrix[k][w];
        if(i != 0){
            ans -= matrix[i-1][w];
        }
        if(j != 0){
            ans -= matrix[k][j-1];
        }
        if(i != 0 && j != 0){
            ans += matrix[i-1][j-1];
        }
        return  ans;
    }


}
